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
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
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

    @RequestMapping(value = "/check-jobCode", method = RequestMethod.POST)
    public Response checkJobCode(@RequestBody String jobCode) throws Exception {
        return new Response().success(userService.checkJobCode(jobCode));
    }

    @RequestMapping(value = "/check-phone", method = RequestMethod.POST)
    public Response checkPhone(@RequestBody String phone) throws Exception {
        return new Response().success(userService.checkPhone(phone));
    }

    @RequestMapping(value = "/check-IDnumber", method = RequestMethod.POST)
    public Response checkIDnumber(@RequestBody String IDnumber) throws Exception {
        return new Response().success(userService.checkIDnumber(IDnumber));
    }

    @RequestMapping(value = "/update-userInfo", method = RequestMethod.POST)
    public Response updateUserInfo(@RequestBody User userInfo) {
        return new Response().success(userService.updateUserInfo(userInfo));
    }

    @RequestMapping(value = "/get-all-userInfo", method = RequestMethod.GET)
    public Response getAllUserInfo() {
        return new Response().success(userService.getAllUserInfo());
    }

    @RequestMapping(value = "/get-all-userInfo-page", method = RequestMethod.POST)
    public Response getAllUserInfoPage(@RequestBody Map<String, String> params) {
        return new Response().success(userService.getAllUserInfoPage(params));
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public Response addUser(@RequestBody Map<String, Object> params) {
        userService.addUser(params);
        return new Response().success();
    }

}
