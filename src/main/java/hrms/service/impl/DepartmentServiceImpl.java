package hrms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import hrms.entity.Department;
import hrms.mapper.DepartmentMapper;
import hrms.mapper.PostMapper;
import hrms.service.IDepartmentService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Resource
    private DepartmentMapper mapper;

    @Resource
    private PostServiceImpl postServiceImpl;

    @Override
    public Department getNameById(Long departId) {
        Map<String, Long> params = new HashMap<>(16);
        params.put("departId", departId);
        return this.mapper.getNameById(params);
    }

    @Override
    public void deleteDepartment(Long departId) {
        List<Long> departIds = new ArrayList<>();
        departIds.add(departId);
        while(departIds.size() != 0) {
            Department temp = new Department();
            List<Department> departments = temp.selectList(new EntityWrapper<Department>().in("parentDepart", departIds));
            if (CollectionUtils.isEmpty(departments)) {
                // 删除完毕
                System.out.println("删除完毕");
                break;
            }
            else {
                for (int i = 0; i < departIds.size(); i++) {
                    // 删除这个部门id下的所有岗位
                    this.postServiceImpl.deleteByParent(departIds.get(i));
                    // 删除这个部门
                    this.mapper.deleteById(departIds.get(i));
                }
                departIds.clear();
                for (int i = 0; i < departments.size(); i++) {
                    departIds.add(departments.get(i).getId());
                }
            }
        }
    }

    @Override
    public void updateDepartment(Department department) {
        Department oldDepart = this.mapper.selectById(department.getId());
        oldDepart.setName(department.getName());
        Long parentId = (this.mapper.selectById(department.getParentDepart())).getId();
        oldDepart.setParentDepart(parentId);
        oldDepart.setRemark(department.getRemark());
        oldDepart.updateAllColumnById();
    }

    @Override
    public void addDepartment(Department department) {
        this.mapper.insert(department);
    }

    @Override
    public boolean checkDepartment(String departmentName) {
        //true：存在重复 false：不存在
        List<Department> departList = new Department().selectList(new EntityWrapper<>().eq("name", departmentName));
        if (CollectionUtils.isEmpty(departList)) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public List<Department> getAll() {
        return this.mapper.getAll();
    }
}
