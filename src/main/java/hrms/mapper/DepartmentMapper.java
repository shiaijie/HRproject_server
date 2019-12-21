package hrms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import hrms.entity.Department;
import hrms.entity.NzOrganization;
import hrms.entity.User;
import org.apache.ibatis.annotations.Param;
import pojo.DepartInfoVo;
import pojo.TreeDataVo;

import java.util.List;
import java.util.Map;
/**
 * <p>
 * 部门信息管理表 Mapper 接口
 * </p>
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 根据部门Id获取部门信息
     * @param params 只存1个部门id
     * @return 部门详细信息：该部门id，该部门名称，上级部门名称，是否为根目录，备注
     */
    Department getNameById(Map<String, Long> params);

    /**
     * 获取所有部门
     * @return 部门列表
     */
    List<Department> getAll();

}
/*
 *//**
 * 获取部门树形数据
 *
 * @param
 * @return 部门数据
 * @author chenshuai
 *//*
    List<TreeDataVo> getDepartmentTreeData();

    *//**
 * 获取部门数据树形数据
 *
 * @param
 * @return 部门数据
 * @author chenshuai
 *//*
    List<TreeDataVo> getDepartmentInfoTreeData();

    *//**
 * 根据层级获取部门树形数据
 *
 * @param
 * @return 部门数据
 * @author chenshuai
 *//*
    List<TreeDataVo> getDepartmentTreeDataByHierarchy(@Param("hierarchy") Integer hierarchy);

    *//**
 * 获取部门负责人的树形结构
 *
 * @param id staffId
 * @return 部门数据
 * @author xinn
 *//*
    List<TreeDataVo> getDepartmentTreeData(@Param("id") Long id);

    *//**
 * 获取顶级节点
 *
 * @param
 * @return 顶级节点
 * @author chenshuai
 *//*
    List<NzOrganization> getAllOrganization();
    List<NzOrganization> getAllOrganizationSimple();

    *//**
 * 获取父部门的最大排序号
 *
 * @param params
 * @return 排序号
 * @author chenshuai
 *//*
    List<Map<String, Long>> getMaxOrderNum(Map<String, String> params);

    *//**
 * 获取部门的树结构
 *
 * @param
 * @return 符合树的结构类型的数据
 * @author chenshuai
 *//*
    List<TreeDataVo> getDeptTree();

    *//**
 * 获取部门下的员工
 *
 * @param params
 * @return 部门ID LIST
 * @author chenshuai
 *//*
    List<User> getDeptStaff(Map<String, List<Long>> params);

    List<Department> getFirstDeptInfo();

    List<Department> getChildDept(Long id);

    List<Long> getChildDeptId(Long id);

    *//**
 * 获取部门下的员工
 *
 * @param departId departId
 * @return 员工 LIST
 * @author xinn
 *//*
    List<User> getDepartmentStaff(@Param("departId") Long departId, @Param("name") String name);

    *//**
 * 获取没有部门的员工
 *
 * @return 员工 LIST
 * @author xinn
 *//*
    List<User> getNoOrganizationStaff();

    *//**
 * 获取没有部门的员工（分页）
 *
 * @return 员工 LIST
 * @author xinn
 *//*
    List<User> getNoOrganizationStaff(Pagination page, @Param("name") String name );

    *//**
 * 移动端获取部门下的通讯录
 *
 * @param page           分页
 * @param departId       选中的部门
 * @return 员工 LIST
 * @author xinn
 *//*
    List<User> getDepartmentStaffApp(Pagination page, @Param("departId") Long departId, @Param("name") String name);

    *//**
 * 得到负责人部门
 * @param departId 部门ID
 * @return 部门负责人
 *//*
    // DepartmentLeaderVo getDepartmentLeader(Long departId);

    *//**
 * 得到负责人部门
 * @param postId 岗位ID
 * @return 部门负责人
 *//*
    // DepartmentLeaderVo getDepartmentLeaderByPostId(Long postId);

    *//**
 * 得到所有部门负责人
 * @return 部门负责人
 *//*
    // List<DepartmentLeaderVo> getDepartmentLeaderList();


    *//**
 * 根据staffId获取部门负责人信息
 * @return 部门负责人
 *//*
    // List<DepartmentLeaderVo> getDepartmentLeaderByStaffId(Long staffId);

    *//**
 * 根据staffId获取人员的岗位信息
 *
 * @param staffId 职员id
 * @return 人员的岗位信息
 *//*
    List<DepartInfoVo> getDepartInfo(Long staffId);

    List<DepartInfoVo> getDepartInfoByDay(@Param("day") String day, @Param("staffId") Long staffId);

    *//**
 * 根据部门ID获取完整部门名称
 *
 * @param id 部门ID
 * @return 完整部门名称
 *//*
    String getDepartMentNameById(Long id);

    *//**
 * 获取全部岗位数据
 * @return
 *//*
    List<Map<String, String>> getPostRemarkReport();

    Department getDepartById(Long id);*/
