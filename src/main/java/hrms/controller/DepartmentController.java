package hrms.controller;

import hrms.com.shiaj.hr.Response;
import hrms.entity.Department;
import hrms.entity.NzTreeNode;
import hrms.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.TreeDataVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门信息管理表 前端控制器
 * </p>
 */

@Controller
@ResponseBody
@RequestMapping("/department")
public class DepartmentController {

    private final IDepartmentService service;

    @Autowired
    public DepartmentController(IDepartmentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/get-name-by-id", method = RequestMethod.POST)
    public Response getNameById(Long departId) throws Exception {
        return new Response().success(service.getNameById(departId));
    }

    @RequestMapping(value = "/delete-department", method = RequestMethod.POST)
    public Response deleteDepartment(Long departId) throws Exception {
        service.deleteDepartment(departId);
        return new Response().success();
    }

    @RequestMapping(value = "/update-department", method = RequestMethod.POST)
    public Response updateDepartment(Department department) throws Exception {
        service.updateDepartment(department);
        return new Response().success();
    }

    @RequestMapping(value = "/add-department", method = RequestMethod.POST)
    public Response addDepartment(Department department) throws Exception {
        service.addDepartment(department);
        return new Response().success();
    }

    @RequestMapping(value = "/check-department", method = RequestMethod.POST)
    public Response checkDepartment(String departmentName) throws Exception {
        return new Response().success(service.checkDepartment(departmentName));
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.POST)
    public Response getAll() throws Exception {
        return new Response().success(service.getAll());
    }
}
/*
    @RequestMapping(value = "/get-department-tree", method = RequestMethod.GET)
    // 取得部门的树形结构数据
    public Response getDepartmentTreeData() {
        List<NzTreeNode> treeData = this.service.getDepartmentTreeData();
        return new Response().success(treeData);
    }

    @RequestMapping(value = "/get-department-tree-by-hierarchy", method = RequestMethod.GET)
    // 取得部门的树形结构数据
    public Response getDepartmentTreeDataByHierarchy(Integer hierarchy) {
        List<NzTreeNode> treeData = this.service.getDepartmentTreeDataByHierarchy(hierarchy);
        return new Response().success(treeData);
    }

    @RequestMapping(value = "/get-department-name/{id}", method = RequestMethod.GET)
    // 取得部门名称（到部级）
    public Response getDepartNameById(@PathVariable("id") Long id) {
        String name = this.service.getDepartNameById(id);
        return new Response().success(name);
    }

    @RequestMapping(value = "/check-departmanager/{id}", method = RequestMethod.GET)
    // 获得员工是部门负责人的所有部门
    public Response checkDepartManager(@PathVariable("id") Long id) {
        List<TreeDataVo> treeData = this.service.getDepartmentTreeData(id);
        return new Response().success(treeData);
    }

    @RequestMapping(value = "/get-department", method = RequestMethod.GET)
    // 取得组织结构数据
    public Response getDepartments() {
        return new Response().success(service.getDepartmentList(false));
    }

    @RequestMapping(value = "/get-all-department", method = RequestMethod.GET)
    // 取得组织结构数据(包含没有部门)
    public Response getAllDepartments() {
        return new Response().success(service.getDepartmentList(true));
    }

    @RequestMapping(value = "/get-no-department-staff", method = RequestMethod.GET)
    // 获取没有部门的人员
    public Response getNoDepartmentStaff(@RequestParam("name") String name, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize) {
        return new Response().success(service.getNoDepartmentStaff(name, current, pageSize));
    }

    // @AutoLog(op = AutoLog.Op.INSERT, module = ModuleEnums.ORGANIZATION)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // 新增部门
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response addDepartment(@RequestBody Department department) {
        service.addDepartment(department);
        return new Response().success();
    }

    // @AutoLog(op = AutoLog.Op.UPDATE, module = ModuleEnums.ORGANIZATION)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    // 更新部门
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response updateDepartment(@RequestBody Department department) {
        service.updateDepartment(department);
        return new Response().success();
    }

    // @AutoLog(op = AutoLog.Op.UPDATE, module = ModuleEnums.ORGANIZATION)
    @RequestMapping(value = "/move-up", method = RequestMethod.POST)
    // 上移
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response moveUp(@RequestBody Department department) {
        service.moveUp(department);
        return new Response().success();
    }

    // @AutoLog(op = AutoLog.Op.UPDATE, module = ModuleEnums.ORGANIZATION)
    @RequestMapping(value = "/move-down", method = RequestMethod.POST)
    // 下移
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response moveDown(@RequestBody Department department) {
        service.moveDown(department);
        return new Response().success();
    }

    @RequestMapping(value = "/dept-tree", method = RequestMethod.GET)
    // 获取部门树
    public Response getDeptTree() {
        return new Response().success(service.getDeptTree());
    }

    // @AutoLog(op = AutoLog.Op.UPDATE, module = ModuleEnums.ORGANIZATION)
    @RequestMapping(value = "/update-pid", method = RequestMethod.POST)
    // 移动至当前节点
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response updatePid(@RequestBody Department department) {
        service.updatePid(department);
        return new Response().success();
    }

    // @AutoLog(op = AutoLog.Op.DELETE, module = ModuleEnums.ORGANIZATION)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    // 删除部门
    // @ApiImplicitParam(name = "deptIdList", value = "子部门ID", paramType = "deptIdList", dataType = "ArrayList", required = true)
    public Response deleteDepartment(@RequestBody CombineDeptAo departmentDel) {
        service.deleteDepartment(departmentDel.getDeptIdList());
        return new Response().success();
    }

    @RequestMapping(value = "/check-dept", method = RequestMethod.POST)
    // 部门名称校验
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response isDepartDuplicated(@RequestBody Department department) {
        return new Response().success(service.isDepartDuplicated(department));
    }

    @RequestMapping(value = "/check-dept-has-staff", method = RequestMethod.GET)
    // 部门下面是否有在职员工
    // @ApiImplicitParam(name = "ids", value = "部门ID集合", paramType = "query", dataType = "List<Long>", required = true)
    public Response checkDepartHasStaff(@RequestParam("ids") List<Long> ids) {
        return new Response().success(service.checkDepartHasStaff(ids));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    // 取得部门列表
    public Response getAll() {
        return new Response().success(service.getAll());
    }

    @RequestMapping(value = "/all-by-hierarchy", method = RequestMethod.GET)
    // 取得部门列表
    public Response getAllByHierarchy(Integer hierarchy) {
        return new Response().success(service.getAllByHierarchy(hierarchy));
    }

    @RequestMapping(value = "/update-all-nodes", method = RequestMethod.POST)
    // 更新整棵树的结构
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response updateAllNodes(@RequestBody DepartTreeVo departTreeVo) {
        service.updateAllNodes(departTreeVo);
        return new Response().success();
    }*/

    /*@RequestMapping(value = "/combine-department", method = RequestMethod.POST)
    // 合并部门
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response combineDepartment(@RequestBody CombineDeptAo combineDeptAo) {
        service.combineDepartment(combineDeptAo);
        return new Response().success();
    }

    @RequestMapping(value = "/split-department", method = RequestMethod.POST)
    // 拆分部门
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response splitDepartment(@RequestBody SplitDeptAo splitDeptAo) {
        service.splitDepartment(splitDeptAo);
        return new Response().success();
    }

    @RequestMapping(value = "/revoke", method = RequestMethod.POST)
    // 撤回上一步
    // @ApiImplicitParam(name = "department", value = "部门对象", paramType = "query", dataType = "Department", required = true)
    public Response revoke() {
        service.revoke();
        return new Response().success();
    }

    @RequestMapping(value = "/get-revoke-flag", method = RequestMethod.GET)
    // 得到是否能撤回的标志
    public Response getRevokeFlag() {
        return new Response().success(service.getRevokeFlag());
    }
*/
    /*@RequestMapping(value = "/get-depart-staff", method = RequestMethod.GET)
    // 部门下的在职员工
    // @ApiImplicitParam(name = "ids", value = "部门ID集合", paramType = "query", dataType = "List<Long>", required = true)
    public Response getDepartStaff(@RequestParam("ids") List<Long> ids) {
        return new Response().success(service.getDepartStaff(ids));
    }

    @RequestMapping(value = "/get-department-staff", method = RequestMethod.GET)
    // 部门下的在职员工
    // @ApiImplicitParam(name = "departId", value = "部门Id", paramType = "query", dataType = "Long", required = true),
    // @ApiImplicitParam(name = "name", value = "员工名称或者工号", paramType = "query", dataType = "String")
    public Response getDepartmentStaff(@RequestParam Long departId, @RequestParam("name") String name) {
        return new Response().success(service.getDepartmentStaff(departId, name));
    }

    @RequestMapping(value = "/get-department-staff-app", method = RequestMethod.GET)
    // 部门下的在职员工(App端通讯录功能
    // @ApiImplicitParam(name = "departId", value = "部门Id", paramType = "query", dataType = "Long", required = true),
    // @ApiImplicitParam(name = "name", value = "员工名称或者工号", paramType = "query", dataType = "String")

    public Response getDepartmentStaffApp(@RequestParam Long departId, @RequestParam("name") String name, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize) {
        return new Response().success(service.getDepartmentStaffApp(departId, name, current, pageSize));
    }


    @RequestMapping(value = "/contact-search-app", method = RequestMethod.GET)
    // App端通讯录搜索功能
    // @ApiImplicitParam(name = "name", value = "员工名称或者工号", paramType = "query", dataType = "String")
    public Response searchApp(@RequestParam("name") String name, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize) {
        return new Response().success(service.searchApp(name, current, pageSize));
    }

    @RequestMapping(value = "/get-staff-info-app", method = RequestMethod.GET)
    // 得到基本信息
    // name = "staffId", value = "员工Id", paramType = "query", dataType = "Long", required = true
    public Response getStaffInfoApp(@RequestParam("staffId") Long staffId) {
        return new Response().success(service.getStaffInfoApp(staffId));
    }

*//*

    @RequestMapping(value = "/have-leader", method = RequestMethod.GET)
    // 判断是否存在负责人职位
    public Response haveLeader(@RequestParam("departId") Long departId) {
        return new Response().success(service.haveLeader(departId));
    }

    @RequestMapping(value = "/get-leader", method = RequestMethod.GET)
    // 通过部门ID获得部门负责人信息
    public Response getDepartmentLeader(@RequestParam("departId") Long departId) {
        return new Response().success(service.getDepartmentLeader(departId));
    }

    @RequestMapping(value = "/get-leader-post-id", method = RequestMethod.GET)
    // 通过岗位ID获得部门负责人信息
    public Response getDepartmentLeaderByPostId(@RequestParam("postId") Long postId) {
        return new Response().success(service.getDepartmentLeaderByPostId(postId));
    }

    @RequestMapping(value = "/get-leader-list", method = RequestMethod.GET)
    // 得到所有部门负责人
    public Response getDepartmentLeaderList() {
        return new Response().success(service.getDepartmentLeaderList());
    }

    @RequestMapping(value = "/have-leader-staff-id", method = RequestMethod.GET)
    // 根据staffId判断是否是部门负责人
    public Response haveDepartmentLeaderByStaffId(@RequestParam("staffId") Long staffId) {
        return new Response().success(service.haveDepartmentLeaderByStaffId(staffId));
    }

    @RequestMapping(value = "/get-leader-staff-id", method = RequestMethod.GET)
    // 根据staffId获取部门负责人信息
    public Response getDepartmentLeaderByStaffId(@RequestParam("staffId") Long staffId) {
        return new Response().success(service.getDepartmentLeaderByStaffId(staffId));
    }

    @RequestMapping(value = "/get-hierarchy-color", method = RequestMethod.GET)
    // 得到层级颜色
    public Response getHierarchyColor() {
        return new Response().success(service.getHierarchyColor());
    }

    @RequestMapping(value = "/set-hierarchy-color", method = RequestMethod.POST)
    // 设置层级颜色
    public Response setHierarchyColor(@RequestBody Map<String, String> colorMaps) {
        service.setHierarchyColor(colorMaps);
        return new Response().success();
    }

    @RequestMapping(value = "/can-adjust-post-because-leader", method = RequestMethod.GET)
    // 根据岗位信息判断是否能调岗、转正（部门负责人因素影响，即：部门负责人职位只能有一位在职员工）
    // @ApiImplicitParam(name = "departId", value = "部门Id", paramType = "query", dataType = "Long"),
    // @ApiImplicitParam(name = "postId", value = "岗位Id", paramType = "query", dataType = "Long"),
    // @ApiImplicitParam(name = "dutyId", value = "职位Id", paramType = "query", dataType = "Long"),
    // @ApiImplicitParam(name = "staffId", value = "职员staffId", dataType = "Long")
    public Response canAdjustPost(@RequestParam("departId") Long departId, @RequestParam("postId") Long postId, @RequestParam("dutyId") Long dutyId, @RequestParam("staffId") Long staffId) {
        return  staffId != null ? new Response().success(service.canAdjustPost(departId, postId, dutyId, staffId)) : new Response().success(service.canAdjustPost(departId, postId, dutyId));
    }
*//*


    @RequestMapping(value = "/update-full-name", method = RequestMethod.GET)
    // 更新部门全名
    public Response updateFullName() {
        service.updateFullName();
        return new Response().success();
    }*/
