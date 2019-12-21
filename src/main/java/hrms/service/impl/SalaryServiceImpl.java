package hrms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import hrms.entity.Salary;
import hrms.entity.User;
import hrms.mapper.SalaryMapper;
import hrms.service.ISalaryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 薪资信息管理表 服务实现类
 */
@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements ISalaryService {
    @Resource
    private SalaryMapper mapper;

    private UserServiceImpl userService;

    @Override
    public List<Salary> getAll() {
        return this.mapper.getAll();
    }

    @Override
    public List<Salary> searchSalary(Map<String, Object> params) {
        return this.mapper.searchSalary(params);
    }

    @Override
    public void deleteSalary(String jobCode, String date) {
        Map<String, Object> params = new HashMap<>(16);
        params.put("jobCode", jobCode);
        params.put("date", date);
        List<Salary> del = this.mapper.searchSalary(params);
        if (del.size() > 1){
            System.out.println("删除出错");
        }
        else if (del.size() == 0) {
            System.out.println("不存在该人员");
        }
        else if (del.size() == 1) {
            this.mapper.deleteById(del.get(0).getId());
        }
    }

    @Override
    public void updateSalary(Salary salary) {
        Salary oldSalary = this.mapper.selectById(salary.getId());
        oldSalary.setBasicSalary(salary.getBasicSalary());
        oldSalary.setSubsidy(salary.getSubsidy());
        oldSalary.setSocialInsurance(salary.getSocialInsurance());
        oldSalary.setAccumulationFund(salary.getAccumulationFund());
        oldSalary.setOtherAdd(salary.getOtherAdd());
        oldSalary.setOtherMinus(salary.getOtherMinus());
        oldSalary.setTotalWage(salary.getTotalWage());
        oldSalary.setYearMonth(salary.getYearMonth());
        oldSalary.updateAllColumnById();
    }

    @Override
    public void addSalary(Salary salary) {
        // 查询该salary的工号是否在user表内存在，不存在的话不能加
        String jobCode = salary.getJobCode();
        User user = new User();
        user = userService.selectOne(new EntityWrapper<User>().eq("jobCode", salary.getJobCode()));
        if (user != null){
            // 检索工资表内是否已有该员工的该日期的工资单
            boolean judge = this.checkSalary(salary.getJobCode(), salary.getYearMonth());
            // 没有的话
            if (judge == false) {
                this.mapper.insert(salary);
            }
            else {
                System.out.println("不能添加");
            }
            // 可以添加该员工薪资
            // 有的话
            // 不可添加
        }
    }

    @Override
    public boolean checkSalary(String jobCode, Date date) {
        // 是否已存在相同年月的该员工工资单
        //true：存在重复 false：不存在
        List<Salary> salaryList = new Salary().selectList(new EntityWrapper<>().eq("jobCode", jobCode).eq("date", date));
        if (CollectionUtils.isEmpty(salaryList)) {
            return false;
        }
        else {
            return true;
        }
    }
}
