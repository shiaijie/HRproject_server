package hrms.service;

import com.baomidou.mybatisplus.service.IService;
import hrms.entity.Post;
import hrms.entity.User;
import javafx.geometry.Pos;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @since 2019-12-01
 */
public interface IPostService extends IService<Post> {

    /**
     * 获取所有岗位
     * @return 所有岗位信息
     */
    List<Post> getAll();

    /**
     * 根据岗位id获取岗位信息
     * @param postId 岗位id
     * @return 岗位详细信息
     */
    Post getPostById(Long postId);

    /**
     * 根据岗位Id删除该岗位
     * @param postId 要删除的岗位Id
     */
    void deletePost(Long postId);

    /**
     * 更新岗位信息
     * @param post 岗位信息
     */
    void updatePost(Post post);

    /**
     * 新增岗位信息
     * @param post 要新增的岗位信息
     */
    void addPost(Post post);

    /**
     * 验证岗位名称唯一性
     * @param postName 岗位名称
     * @return true：存在重复 false：不存在
     */
    boolean checkPost(String postName);

    /**
     * 根据所属部门id删除岗位
     * @param departId 所属部门id
     */
    void deleteByParent(Long departId);
}
/*
 */
/**
 * 获取所有岗位
 *
 * @return 全部岗位
 * @author chenshuai
 *//*

    List<Post> getAll();

    */
/**
 * 保存岗位
 *
 * @param post 岗位对象
 * @return 新的岗位对象
 * @author chenshuai
 *//*

    Post savePost(Post post);

    */
/**
 * 更新岗位
 *
 * @param post 岗位对象
 * @return 新的岗位对象
 * @author chenshuai
 *//*

    Post updatePost(Post post);

    */
/**
 * 删除岗位
 *
 * @param id 岗位ID
 * @return void
 * @author chenshuai
 *//*

    void deletePost(String id);

    */
/**
 * 岗位详情
 *
 * @param id 岗位ID
 * @return 岗位对象
 * @author chenshuai
 *//*

    Post postDetail(String id);

    */
/**
 * 获取部门岗位树
 *
 * @return 部门岗位LIST
 * @author chenshuai
 *//*

     List<Object> getDeptPostTableList(Boolean export);

    */
/**
 * 获取部门岗位树（不包含岗位）
 *
 * @return 部门岗位LIST
 *//*

    // List<NzOrganization> getDeptPostTableListNoPost();

    List<Object> getDeptPostTree(String key, List<PostTree> postTree);

    */
/**
 * 确认岗位下是否存在在职员工
 *
 * @param ids 岗位及其子岗位ID
 * @return boolean true：已存在 false：不存在
 * @author chenshuai
 *//*

    boolean checkPostPeople(List<Long> ids);

    */
/**
 * 获取该岗位所有在职员工
 *
 * @param postId
 * @param dutyId
 * @return 在职员工对象LIST
 * @author chenshuai
 *//*

    List<User> getIncumbencyPeople(Long postId, Long dutyId);

    */
/**
 * 获取所有该部门的岗位
 *
 * @param departId 部门ID
 * @return 岗位对象LIST
 * @author chenshuai
 *//*

    List<Post> getPostInDept(Long departId);

    */
/**
 * 判断是否存在相同部门，岗位
 *
 * @param name 岗位名称
 * @param departId 部门ID
 * @param postId 岗位ID
 * @param id 当前岗位ID
 * @return boolean true：存在， false：不存在
 * @author chenshuai
 *//*

    boolean checkDeptPost(String name, Long departId, Long postId, Long id);

    */
/**
 * 判断是否存在相同岗位下的职位
 *
 * @param postId 岗位ID
 * @param dutyId 职位ID
 * @param id 职位ID
 * @return boolean true：存在， false：不存在
 * @author chenshuai
 *//*

    boolean checkDuty(Long postId, Long dutyId, Long id);

    */
/**
 * 获取该岗位下所有职位
 *
 * @param postId 岗位ID
 * @return 岗位LIST
 * @author chenshuai
 *//*

    List<Duty> getDutyInPost(Long postId);

    */
/**
 * 保存职位
 *
 * @param postDuty 职位ID
 * @return void
 * @author chenshuai
 *//*

    void saveDuty(Duty postDuty);

    */
/**
 * 更新职位
 *
 * @param postDuty
 * @return void
 * @author chenshuai
 *//*

    void updateDuty(Duty postDuty);

    */
/**
 * 批量新增职位
 *
 * @param list 职位LIST
 * @return void
 * @author chenshuai
 *//*

    void batchSaveDuty(List<Duty> list);

    */
/**
 * 删除职位
 *
 * @param id 职位ID
 * @return void
 * @author chenshuai
 *//*

    void deleteDuty(Long id);

    */
/**
 * 验证职位是否有在职员工
 *
 * @param departId 部门ID
 * @param postId 岗位ID
 * @param dutyId 职位ID
 * @return boolean true：存在， false：不存在
 * @author chenshuai
 *//*

    boolean checkDuty(String departId, String postId, String dutyId);

    */
/**
 * 获得带有部门名称的所有岗位
 *
 * @param departId 部门ID
 * @return 岗位LIST
 * @author chenshuai
 *//*

    List<Post> getPostDepart(String departId);

    */
/**
 * 根据岗位id取得岗位名称
 *
 * @param postId 岗位id
 * @return 岗位名称
 * @author zhao
 *//*

    String getPostName(String postId);

    void move(MovePostAo movePostAo);

    */
/**
 * 获取该岗位所有兼职代任员工
 *
 * @param postId 部门id
 * @param dutyId 岗位id
 * @return 兼职代任员工对象LIST
 * @author xinn
 *//*

    List<User> getPartTimePeople(Long postId, Long dutyId);

    */
/**
 * 获取该岗位所有储备员工
 *
 * @param postId 部门id
 * @param dutyId 岗位id
 * @return 储备员工对象LIST
 * @author xinn
 *//*

    List<User> getReservePeople(Long postId, Long dutyId);

    Integer getFormationPeopleNumber(String departId, String postId, String dutyId);

    void exportPostRemark(Long id);

    void exportPostRemarkAll();
*/
