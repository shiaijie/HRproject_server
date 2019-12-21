package hrms.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import hrms.entity.Department;
import hrms.entity.NzOrganization;
import hrms.entity.NzTreeNode;
import hrms.entity.User;
import org.springframework.transaction.annotation.Transactional;
import pojo.DepartInfoVo;
import pojo.TreeDataVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门信息管理表 服务类
 * </p>
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 根据部门Id获取部门信息
     * @param departId 部门id
     * @return 部门详细信息
     */
    Department getNameById(Long departId);

    /**
     * 根据部门Id删除该部门以及该部门下的所有部门和岗位
     * @param departId 要删除的部门Id
     */
    void deleteDepartment(Long departId);

    /**
     * 更新部门信息
     * @param department 部门信息
     */
    void updateDepartment(Department department);

    /**
     * 新增部门
     * @param department 新增部门信息
     */
    void addDepartment(Department department);

    /**
     * 验证部门名称唯一性
     * @param departmentName 部门名称
     * @return true：存在重复 false：不存在
     */
    boolean checkDepartment(String departmentName);

    /**
     * 获取全部部门信息
     * @return 所有部门信息
     */
    List<Department> getAll();

}
/*


 */
/**
 * 获取部门list
 *
 * @param showNoDepart 是否需要显示无部门
 * @return 部门list
 * @author chenshuai
 *//*

    List<NzOrganization> getDepartmentList(boolean showNoDepart);


    */
/**
 * 保存部门
 *
 * @param department 部门对象
 * @return void
 * @author chenshuai
 *//*

    void addDepartment(Department department);

    */
/**
 * 更新部门
 *
 * @param department 部门对象
 * @return void
 * @author chenshuai
 *//*

    void updateDepartment(Department department);

    */
/**
 * 上移
 *
 * @param department 部门对象
 * @return void
 * @author chenshuai
 *//*

    void moveUp(Department department);

    */
/**
 * 下移
 *
 * @param department
 * @return void
 * @author chenshuai
 *//*

    void moveDown(Department department);

    */
/**
 * 获取部门树
 *
 * @return 部门的树结构
 * @author chenshuai
 *//*

    List<NzTreeNode> getDeptTree();

    */
/**
 * 移动至当前节点
 *
 * @param department 部门对象
 * @return void
 * @author chenshuai
 *//*

    void updatePid(Department department);

    */
/**
 * 删除部门
 *
 * @return void
 * @author chenshuai
 *//*

    void deleteDepartment(List<Long> deptIdList);

    @Transactional(rollbackFor = Exception.class)
    void combineDepartment(CombineDeptAo combineDeptAo);

    @Transactional(rollbackFor = Exception.class)
    void splitDepartment(SplitDeptAo splitDeptAo);

    */
/**
 * 部门名称是否重复
 *
 * @param department 部门对象
 * @return boolean true：存在重复 false：不存在
 * @author chenshuai
 *//*

    boolean isDepartDuplicated(Department department);

    */
/**
 * 判断是否存在员工正在使用该部门
 *
 * @param ids 部门ID集合，包含当前节点和其子节点
 * @return boolean true：使用中 false：未使用
 * @author chenshuai
 *//*

    boolean checkDepartHasStaff(List<Long> ids);

    */
/**
 * 获取全部部门
 *
 * @return 部门LIST
 * @author chenshuai
 *//*

    List<Department> getAll();


    List<Department> getAllByHierarchy(Integer hierarchy);

    TreeNodeDepart getDepartTreeNode(Long id);

    */
/**
 * 根据部门id查找所有子部门
 *
 * @param id
 * @return 子部门集合
 * @author chenshuai
 *//*

    List<NzTreeNode> getAllChildren(String id);

    */
/**
 * 更新部门的显示顺序（人员库按照此顺序显示）
 *//*

    boolean updateOrderNumForStaffLib();

    */
/**
 * 获取部门的员工
 *
 * @param ids 部门ID
 * @return 员工信息
 * @author chenshuai
 *//*

    List<User> getDepartStaff(List<Long> ids);

    */
/**
 * 根据部门id取得部门名称
 *
 * @param id 部门id
 * @return 部门名称
 * @author zhao
 *//*

    String getDeptName(String id);

    */
/**
 * 更新整棵树的结构
 *
 * @param departTreeVo
 * @author chenshuai
 *//*

    void updateAllNodes(DepartTreeVo departTreeVo);

    */
/**
 * 撤回（数据还原）
 *
 * @param
 * @author chenshuai
 *//*

    void revoke();

    */
/**
 * 获取部门的员工
 *
 * @param departId 部门ID
 * @return 员工信息
 * @author chenshuai
 *//*

    List<User> getDepartmentStaff(Long departId, String name);

    */
/**
 * 获取部门下的员工（App通讯录设置）
 *
 * @param departId 选中的部门Id
 * @param name     搜索条件
 * @param current  当前页数
 * @param pageSize 每页显示的条数
 * @return 员工集合
 * @author xinn
 *//*

    Page<User> getDepartmentStaffApp(Long departId, String name, Integer current, Integer pageSize);

    */
/**
 * 获取部门下的员工（App通讯录设置）
 *
 * @param name     搜索条件
 * @param current  当前页数
 * @param pageSize 每页显示的条数
 * @return 员工集合
 * @author xinn
 *//*

    Page<User> getNoDepartmentStaff(String name, Integer current, Integer pageSize);


    */
/**
 * （App通讯录搜索）
 *
 * @param name     搜索条件
 * @param current  当前页数
 * @param pageSize 每页显示的条数
 * @return 员工集合
 * @author xinn
 *//*

    Page<User> searchApp(String name, Integer current, Integer pageSize);

    */
/**
 * 员工基础信息APP端
 *
 * @param staffId staffId
 * @return 员工
 * @author xinn
 *//*

    User getStaffInfoApp(Long staffId);

    */
/**
 * 对通讯录信息展示进行处理
 *
 * @param list     集合
 * @param departId 部门Id
 * @author xinn
 *//*

    void handleShowInfo(List<User> list, Long departId);

    */
/**
 * 判断是否存在负责人职位
 * @param departId 部门ID
 * @return 存在返回true,否则反之
 * @author nitmali
 *//*

    boolean haveLeader(Long departId);

    */
/**
 * 得到负责人职位
 * @param departId 部门ID
 * @return DepartmentLeaderVo
 * @author nitmali
 *//*

    // DepartmentLeaderVo getDepartmentLeader(Long departId);

    */
/**
 * 得到负责人职位
 * @param postId 岗位ID
 * @return DepartmentLeaderVo
 * @author nitmali
 *//*

    // DepartmentLeaderVo getDepartmentLeaderByPostId(Long postId);

    */
/**
 * 得到所有部门负责人
 * @return 部门负责人
 * @author nitmali
 *//*

    // List<DepartmentLeaderVo> getDepartmentLeaderList();

    */
/**
 * 根据staffId判断是否是部门负责人
 * @param staffId staffId
 * @return boolean
 * @author nitmali
 *//*

    // boolean haveDepartmentLeaderByStaffId(Long staffId);


    */
/**
 * 根据staffId获取部门负责人信息
 * @param staffId staffId
 * @return DepartmentLeaderVo
 * @author nitmali
 *//*

    // List<DepartmentLeaderVo> getDepartmentLeaderByStaffId(Long staffId);

    */
/**
 * 根据岗位信息判断是否能调岗、转正（部门负责人因素影响，即：部门负责人职位只能有一位在职员工）
 * @param departId 部门Id
 * @param postId 岗位Id
 * @param dutyId 职位Id
 * @return 能调岗返回true，不能返回false
 * @author nitmali
 *//*

    boolean canAdjustPost(Long departId, Long postId, Long dutyId);

    */
/**
 * 根据岗位信息判断是否能调岗、转正（部门负责人因素影响，即：部门负责人职位只能有一位在职员工）
 * @param departId 部门Id
 * @param postId 岗位Id
 * @param dutyId 职位Id
 * @return 能调岗返回true，不能返回false，若staffId与负责人staffId一至，则不视为调岗，返回true
 * @author nitmali
 *//*

    boolean canAdjustPost(Long departId, Long postId, Long dutyId, Long staffId);


    */
/**
 * 根据岗位信息判断是否能调岗、转正（部门负责人因素影响，即：部门负责人职位只能有一位在职员工）
 * @param departId 部门Id
 * @param postId 岗位Id
 * @param dutyId 职位Id
 * @return DepartmentLeaderVo 不能则返回当前部门负责人
 * @author nitmali
 *//*

    // DepartmentLeaderVo canAdjustPostInfo(Long departId, Long postId, Long dutyId);

    */
/**
 * 删除老的部门负责人
 * @param departId 部门Id
 * @param postId 岗位Id
 * @param dutyId 职位Id
 * @author nitmali
 *//*

    void removeOldLeader(Long departId, Long postId, Long dutyId);

    */
/**
 * 根据departID 获得部门信息
 *
 * @param departId 部门id
 * @return 部门信息
 * @author xinn
 *//*

    NzOrganization getDepartInfoById(Long departId);

    */
/**
 * 根据departId获取部门信息
 *
 * @param departId 部门Id
 * @author mason
 *//*

    Department getNameById(Long departId);

    */
/**
 * 根据departId获取部门信息 (name包含上级)
 *
 * @param departId 部门Id
 * @author nitmali
 *//*

    Department getDepartById(Long departId);

    */
/**
 * 根据staffId获取对应的岗位信息
 * 包含岗位ID和名称
 *
 * @param staffId 员工Id
 * @return 岗位信息
 *//*

    DepartInfoVo getDepartInfo(Long staffId);

    DepartInfoVo getDepartInfoByDay(String day, Long staffId);

    */
/**
 * 获取部门树形数据
 *
 * @return 部门树形数据
 *//*

    List<NzTreeNode> getDepartmentTreeData();

    List<NzTreeNode> getDepartmentTreeDataByHierarchy(Integer hierarchy);
    */
/**
 * 获取部门负责人的树形结构
 *
 * @param id staffId
 * @return 部门数据
 *//*

    List<TreeDataVo> getDepartmentTreeData(Long id);

    */
/**
 * 得到是否能撤回的标志
 *
 * @return true/能  false/不能
 *//*

    boolean getRevokeFlag();

    */
/**
 * 得到层级颜色
 *//*

    Map<String, String> getHierarchyColor();

    */
/**
 * 设置层级颜色
 *
 * @param colorMaps 颜色
 *//*

    void setHierarchyColor(Map<String, String> colorMaps);

    */
/**
 * 根据ID获取部门名称（以/划分到部级)
 * eg:开发本部/开发一部/产品组
 *
 * @param id 底级部门ID
 * @return 部门完整名称
 *//*

    String getDepartNameById(Long id);


    */
/**
 * 查找到层级为1的部门全名
 *
 * @param departName   部门名称
 * @param parentDepart 父部门ID
 * @param hierarchy    部门层级
 * @return 全名
 *//*

    String getDepartFullName(String departName, Long parentDepart, Integer hierarchy);

    */
/**
 * 更新部门全名
 *//*

    void updateFullName();

    void getDepartChildrenId(List<Long> departChildrenId, TreeNodeDepart node, Integer hierarchy);
*/
