package controller;

import com.shiaj.hr.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.IPostService;

@Controller
@RequestMapping("/post")
public class PostController {
    private IPostService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Response getAll() {
        return new Response().success(service.getAll());
    }

}
