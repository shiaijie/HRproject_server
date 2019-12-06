package controller;

import com.shiaj.hr.Response;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.IUserService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2019-12-01
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(String jobCode, String password) throws Exception {
        return new Response().success(userService.login(jobCode, password));
    }

}
