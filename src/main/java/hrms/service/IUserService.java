package hrms.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import hrms.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @since 2019-12-01
 */
public interface IUserService extends IService<User> {

    /**
     * 登录
     * @param jobCode 工号（账号）
     * @param password 密码
     * @return 用户信息
     * @throws Exception 异常
     */
    User login(String jobCode, String password) throws Exception;

    /**
     * 注册
     * @param params 注册所需信息
     */
    boolean register(Map<String,Object> params);

    /**
     * 验证工号唯一性
     * @param jobCode 工号
     */
    boolean checkJobCode(String jobCode);

    /**
     * 验证手机号唯一性
     * @param phone 手机号
     * @return
     */
    boolean checkPhone(String phone);

    /**
     * 验证身份证号唯一性
     * @param IDnumber 身份证号
     * @return
     */
    boolean checkIDnumber(String IDnumber);

    /**
     * 添加人员
     * @param params 人员信息
     */
    void addUser(Map<String, Object> params);

    /**
     * 更新人员信息
     */
    User updateUserInfo(User userInfo);

    /**
     * 获取所有员工信息(不分页)
     */
    List<User> getAllUserInfo();

    /**
     * 获取员工信息（分页）
     */
    Page<User> getAllUserInfoPage(Map<String, String> params);


}
