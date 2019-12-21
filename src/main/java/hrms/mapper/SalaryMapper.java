package hrms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import hrms.entity.Salary;

import java.util.List;
import java.util.Map;

public interface SalaryMapper extends BaseMapper<Salary> {
    /**
     * 获取所有薪资信息
     * @return 薪资信息列表
     */
    List<Salary> getAll();

    /**
     * 根据搜索条件搜索薪资信息
     * @param params 搜索条件
     * @return 薪资信息列表
     */
    List<Salary> searchSalary(Map<String, Object> params);

}
