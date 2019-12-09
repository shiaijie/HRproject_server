package hrms.service;

import com.baomidou.mybatisplus.service.IService;
import hrms.entity.User;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
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
}
