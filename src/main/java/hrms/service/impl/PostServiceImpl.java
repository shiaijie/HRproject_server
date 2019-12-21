package hrms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oracle.webservices.internal.api.message.MessageContext;
import hrms.entity.Post;
import hrms.entity.User;
import hrms.mapper.PostMapper;
import hrms.service.IPostService;
import hrms.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 岗位信息管理表 服务实现类
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {
    @Resource
    private PostMapper mapper;

    @Override
    public List<Post> getAll() {
        return this.mapper.getAll();
    }

    @Override
    public Post getPostById(Long postId) {
        Map<String, Long> params = new HashMap<>(16);
        params.put("postId", postId);
        return this.mapper.getPostById(params);
    }

    @Override
    public void deletePost(Long postId) {
        this.mapper.deleteById(postId);
    }

    @Override
    public void updatePost(Post post) {
        Post oldPost = this.mapper.selectById(post.getId());
        oldPost.setName(post.getName());
        oldPost.setDepartId(post.getDepartId());
        oldPost.setRemark(post.getRemark());
        oldPost.updateAllColumnById();
    }

    @Override
    public void addPost(Post post) {
        this.mapper.insert(post);
    }

    @Override
    public boolean checkPost(String postName) {
        //true：存在重复 false：不存在
        List<Post> postList = new Post().selectList(new EntityWrapper<>().eq("name", postName));
        if (CollectionUtils.isEmpty(postList)) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void deleteByParent(Long departId) {
        List<Post> postList = new Post().selectList(new EntityWrapper<>().eq("departId", departId));
        if (!CollectionUtils.isEmpty(postList)) {
            for (int i = 0; i < postList.size(); i++) {
                this.mapper.deleteById(postList.get(i).getId());
            }
        }
    }


}
/* DepartmentMapper departmentMapper;

    private IPostDutyService postDutyService;
    private PostMapper mapper;

    @Autowired
    private MessageContext message;

    @Resource
    private IUserService configService;

    @Autowired
    public PostServiceImpl(DepartmentMapper departmentMapper, IPostDutyService postDutyService, PostMapper mapper) {
        this.departmentMapper = departmentMapper;
        this.postDutyService = postDutyService;
        this.mapper = mapper;
    }

    @Override
    public List<Post> getAll() {
        return this.baseMapper.allPost();
    }

    @Override
    public Post savePost(Post post) {
        post.insert();
        return post;
    }

    @Override
    public Post updatePost(Post post) {
        Post postT = this.selectById(post.getId());
        postT.setName(post.getName());
        postT.setRemark(post.getRemark());
        postT.updateAllColumnById();
        return post;
    }

    *//**
 * 递归删除子岗位
 *
 * @param id
 * @author chenshuai
 *//*
    private void delChildren(Long id) {
        EntityWrapper<Post> wrapper = new EntityWrapper<>();
        wrapper.eq("deleteFlag", 0).eq("postId", id);
        List<Post> children = this.baseMapper.selectList(wrapper);
        if (CollectionUtils.isNotEmpty(children)) {
            for (Post child : children) {
                child.setDeleteFlag(1);
                child.setGmtUpdate(new Date());
                child.updateById();
                // 删除关联关系
                Wrapper<PostDuty> ew = new EntityWrapper<>();
                ew.eq("postId", child.getId());
                postDutyService.delete(ew);

                delChildren(child.getId());
            }
        }
    }

    @Override
    public Post postDetail(String id) {
        return this.selectById(id);
    }

    @Override
    public List getDeptPostTableList(Boolean export) {
        return  getDepartmentList(export);
    }

    @Override
    public List<NzOrganization> getDeptPostTableListNoPost() {
        List<NzOrganization> allOrganization = departmentMapper.getAllOrganization();
        List<NzOrganization> collect = allOrganization.stream()
                .filter(item -> StringUtils.isBlank(item.getParentDepart()))
                .peek(root -> {
                    // 先设置子部门
                    root.setChildren(getChildren(root, allOrganization));
                    // 对子部门排序，助理部门排在上面
                    root.setChildren(root.getChildren().stream().sorted(Comparator.comparing(NzOrganization::getAssist).reversed()).collect(Collectors.toList()));
                    root.setIsLeaf(root.getChildren().size() == 0);
                }).collect(Collectors.toList());
        return collect;
    }

    private List<NzOrganization> getChildren(NzOrganization parent, List<NzOrganization> allOrganization) {
        List<NzOrganization> chCh = allOrganization.stream()
                .filter(item -> HRUtil.same(item.getParentDepart(), String.valueOf(parent.getKey())))
                .peek(ch -> {
                    ch.setChildren(getChildren(ch, allOrganization));
                    ch.setIsLeaf(ch.getChildren().size() == 0);
                })
                .collect(Collectors.toList());
        parent.setFormationTotal(parent.getFormationFullPeopleNumber() != null ? parent.getFormationFullPeopleNumber() : 0);
        parent.setIncumbencyTotal(parent.getIncumbencyFullPeopleNumber() != null ? parent.getIncumbencyFullPeopleNumber() : 0);
        parent.setFormationTotal(chCh.stream().mapToInt(NzOrganization::getFormationTotal).sum() + parent.getFormationTotal());
        parent.setIncumbencyTotal(chCh.stream().mapToInt(NzOrganization::getIncumbencyTotal).sum() + parent.getIncumbencyTotal());
        return chCh;
    }

    @Override
    public boolean checkPostPeople(List<Long> ids) {
        Map<String, List<Long>> params = new HashMap<>(16);
        params.put("ids", ids);
        return this.baseMapper.checkPostPeople(params).size() > 0;
    }

    @Override
    public List<User> getIncumbencyPeople(Long postId, Long dutyId) {
        Map<String, Long> params = new HashMap<>(16);
        params.put("postId", postId);
        params.put("dutyId", dutyId);
        return this.baseMapper.getIncumbencyPeople(params);
    }

    @Override
    public List<User> getPartTimePeople(Long postId, Long dutyId) {
        Map<String, Long> params = new HashMap<>(16);
        params.put("postId", postId);
        params.put("dutyId", dutyId);
        return this.baseMapper.getPartTimePeople(params);
    }

    @Override
    public List<User> getReservePeople(Long postId, Long dutyId) {
        Map<String, Long> params = new HashMap<>(16);
        params.put("postId", postId);
        params.put("dutyId", dutyId);
        return this.baseMapper.getReservePeople(params);
    }

    @Override
    public Integer getFormationPeopleNumber(String departId, String postId, String dutyId) {
        Integer d = this.mapper.getFormationPeopleNumber(departId, postId, dutyId);
        return d == null ? Integer.valueOf(0) : d;
    }

    @Override
    public void exportPostRemark(Long id) {
        Post post = this.selectById(id);
        if (post.getRemark() == null) {
            post.setRemark("");
        }
        if (post.getResponsibilities() == null) {
            post.setResponsibilities("");
        }
        if (post.getQualification() == null) {
            post.setQualification("");
        }
        docxUtil.writeResponse(HttpUtil.getResponse(), "/word/post-remark.docx", post);
    }

    @Override
    public void exportPostRemarkAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("datas", departmentMapper.getPostRemarkReport());
        excelUtil.writeResponse(HttpUtil.getResponse(), "/xlsx/postRemarkReport.xlsx", map);
    }

    @Override
    public List<Post> getPostInDept(Long departId) {
        Map<String, Long> params = new HashMap<>(16);
        params.put("departId", departId);
        List<Tree> listTree = this.baseMapper.getPostInDept(params);
        return Tree.buildTree(listTree);
    }

    @Override
    public boolean checkDeptPost(String name, Long departId, Long postId, Long id) {
        Wrapper<Post> ew = new EntityWrapper<Post>()
                .eq("deleteFlag", "0")
                .eq("departId", departId)
                .eq("name", name);
        if (id != null) {
            ew.andNew("id <> {0}", id);
        }
        return this.baseMapper.selectList(ew).size() > 0;
    }

    @Override
    public boolean checkPostDuty(Long postId, Long dutyId, Long id) {
        Wrapper<PostDuty> ew = new EntityWrapper<PostDuty>()
                .eq("postId", postId)
                .eq("dutyId", dutyId);
        if (id != null) {
            ew.and("id <> {0}", id);
        }
        return postDutyService.selectList(ew).size() > 0;
    }

    @Override
    public List<Duty> getDutyInPost(Long postId) {
        Map<String, Long> params = new HashMap<>(16);
        params.put("postId", postId);
        return this.baseMapper.getDutyInPost(params);
    }


    @Override
    public void saveDuty(PostDuty postDuty) {
        postDutyService.insert(postDuty);
    }

    @Override
    public void updateDuty(PostDuty postDuty) {
        postDutyService.updateAllColumnById(postDuty);
    }

    @Override
    public void batchSaveDuty(List<PostDuty> list) {
        postDutyService.insertBatch(list);
    }

    @Override
    public void deleteDuty(Long id) {
        postDutyService.deleteById(id);
    }

    @Override
    public boolean checkDuty(String departId, String postId, String dutyId) {
        Map<String, String> params = new HashMap<>(16);
        params.put("departId", departId);
        params.put("postId", postId);
        params.put("dutyId", dutyId);
        List<Map<String, String>> list = this.baseMapper.checkDuty(params);
        return CollectionUtils.isNotEmpty(list);
    }

    private List<NzOrganization> getDepartmentList(Boolean export) {
        List<PostTree> postTrees = getPostTree();
        List<NzOrganization> allOrganization = departmentMapper.getAllOrganization();
        return allOrganization.stream()
                .filter(item -> StringUtils.isBlank(item.getParentDepart()))
                .peek(root -> {
                    // 先设置子部门
                    root.setChildren(getChildren(root, postTrees, allOrganization, export));
                    // 对子部门排序，助理部门排在上面
                    root.setChildren(root.getChildren().stream().sorted(Comparator.comparing(NzOrganization::getAssist).reversed()).collect(Collectors.toList()));

                    if (export != null && export) {
                        // 加上部门下的岗位
                        root.setChildren(getDeptPostTree(root, postTrees));
                    }
                    root.setIsLeaf(false);
                }).collect(Collectors.toList());
    }

    private List<NzOrganization> getChildren(NzOrganization parent, List<PostTree> postTrees, List<NzOrganization> allOrganization, Boolean export) {
        List<NzOrganization> chCh = allOrganization.stream()
                .filter(item -> HRUtil.same(item.getParentDepart(), String.valueOf(parent.getKey())))
                .peek(ch -> {
                    ch.setChildren(getChildren(ch, postTrees, allOrganization, export));
                    if (export != null && export) {
                        //children加上岗位
                        ch.setChildren(getDeptPostTree(ch, postTrees));
                    }
                    ch.setIsLeaf(false);
                })
                .collect(Collectors.toList());
        parent.setFormationTotal(parent.getFormationFullPeopleNumber() != null ? parent.getFormationFullPeopleNumber() : 0);
        parent.setIncumbencyTotal(parent.getIncumbencyFullPeopleNumber() != null ? parent.getIncumbencyFullPeopleNumber() : 0);

        parent.setFormationTotal(chCh.stream().mapToInt(NzOrganization::getFormationTotal).sum() + parent.getFormationTotal());
        parent.setIncumbencyTotal(chCh.stream().mapToInt(NzOrganization::getIncumbencyTotal).sum() + parent.getIncumbencyTotal());
        return chCh;
    }

    private List getDeptPostTree(NzOrganization parent, List<PostTree> postTree) {
        List list = new ArrayList();
        if (CollectionUtils.isNotEmpty(postTree)) {
            for (PostTree tree : postTree) {
                if (tree.getDepartId().equals(parent.getKey())) {
                    list.add(tree);
                }
            }
        }
        list.addAll(parent.getChildren());
        return list;
    }

    @Override
    public List<Object> getDeptPostTree(String key, List<PostTree> postTree) {
        if (postTree == null) {
            postTree = getPostTree();
        }
        return postTree.stream()
                .filter(tree -> tree.getDepartId().toString().equals(key))
                .peek(tree -> {
                    StaffBasicConfig rank = configService.getStaffBasicConfigByKey(StaffConfigEnum.STAFF_JOB_LEVEL.getType(), tree.getPostRank());
                    StaffBasicConfig grade = configService.getStaffBasicConfigByKey(StaffConfigEnum.STAFF_JOB_RANK.getType(), tree.getPostGrade());
                    if (rank != null) {
                        tree.setPostRank(rank.getFieldvalue());
                    }
                    if (grade != null) {
                        tree.setPostGrade(grade.getFieldvalue());
                    }
                })
                .collect(Collectors.toList());
    }

    private List<PostTree> getPostTree() {
        List postTrees = this.baseMapper.tableList();
        return Tree.buildTree(postTrees);
    }

    @Override
    public List<PostViewModel> getPostDepart(String departId) {
        Map<String, String> param = new HashMap<>(2);
        param.put("departId", departId);
        List<PostViewModel> postDepart = this.mapper.getPostDepart(param);
        Optional.ofNullable(postDepart).orElse(Collections.emptyList()).forEach(item -> {
            DepartmentLeaderVo leaderVo = departmentMapper.getDepartmentLeaderByPostId(item.getId());
            item.setDeptManager(leaderVo != null);
        });
        return postDepart;
    }

    @Override
    public String getPostName(String postId) {
        Wrapper<Post> wrapper = new EntityWrapper<>(new Post(), "name")
                .eq("deleteFlag", 0).eq("id", Long.parseLong(postId));
        Post post = this.selectOne(wrapper);
        return post.getName();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void move(MovePostAo movePostAo) {
        DepartmentLeaderVo departmentLeaderVo = departmentMapper.getDepartmentLeaderByPostId(movePostAo.getPostId());
        if (departmentLeaderVo != null) {
            if (departmentMapper.getDepartmentLeader(movePostAo.getTargetDeptId()) != null) {
                throw new SysRuntimeException(this.message.getMessage("W336"));
            } else {
                Wrapper<PostDuty> ew = new EntityWrapper<>();
                ew.eq("postId", departmentLeaderVo.getPostId()).eq("leader",
                        departmentLeaderVo.getDepartId()).eq("dutyId", departmentLeaderVo.getDutyId());
                PostDuty postDuty = new PostDuty().selectOne(ew);
                postDuty.setLeader(movePostAo.getTargetDeptId()).updateAllColumnById();
            }
        }

        Wrapper<StaffMajorJob> maJorEw = new EntityWrapper<>();
        maJorEw.eq("postId", movePostAo.getPostId()).eq("deleteFlag", 0).eq("termination", 0);
        Wrapper<StaffPartTimeJob> partEw = new EntityWrapper<>();
        partEw.eq("postId", movePostAo.getPostId()).eq("deleteFlag", 0).eq("termination", 0);
        if (!new StaffMajorJob().selectList(maJorEw).isEmpty() || !new StaffPartTimeJob().selectList(partEw).isEmpty()) {
            throw new SysRuntimeException(this.message.getMessage("W362"));
        }

        Post post = this.selectById(movePostAo.getPostId());
        post.setDepartId(movePostAo.getTargetDeptId());
//        post.setPostId(movePostAo.getTargetPostId());
        post.updateAllColumnById();
    }*/
