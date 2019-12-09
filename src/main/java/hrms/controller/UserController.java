package hrms.controller;

import hrms.com.shiaj.hr.Response;
import hrms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hrms.service.IUserService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2019-12-01
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody User user) throws Exception {
        return new Response().success(userService.login(user.getJobCode(), user.getPassword()));
    }

}
