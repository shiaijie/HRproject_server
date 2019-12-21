package hrms.service;

import com.baomidou.mybatisplus.service.IService;
import hrms.entity.Salary;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ISalaryService extends IService<Salary> {

    /**
     * 获取所有薪资条信息
     */
    List<Salary> getAll();

    /**
     * 根据搜索条件查找该员工的所有年月薪资信息
     * @param params 搜索条件
     * @return 该员工的薪资信息
     */
    List<Salary> searchSalary(Map<String,Object> params);

    /**
     * 删除该员工、该月的薪资信息
     * @param jobCode 员工工号
     * @param date 年月
     */
    void deleteSalary(String jobCode, String date);

    /**
     * 更新薪资信息
     * @param salary 薪资信息
     */
    void updateSalary(Salary salary);

    /**
     * 新增一条薪资信息
     * @param salary 薪资信息
     */
    void addSalary(Salary salary);

    /**
     * 验证一条薪资信息的唯一性
     * @param jobCode 员工工号
     * @param date 年月
     * @return true：存在重复 false：不存在
     */
    boolean checkSalary(String jobCode, Date date);

}
