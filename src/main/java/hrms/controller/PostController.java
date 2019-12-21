package hrms.controller;

import hrms.com.shiaj.hr.Response;
import hrms.entity.Post;
import hrms.service.IPostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 岗位信息管理表 前端控制器
 * </p>
 */
@Controller
@ResponseBody
@RequestMapping("/post")
public class PostController {
    private final IPostService postService;

    @Autowired
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.POST)
    public Response getAll() throws Exception {
        return new Response().success(postService.getAll());
    }

    @RequestMapping(value = "/get-post-by-id", method = RequestMethod.POST)
    public Response postDetail(@RequestBody Long postId) throws Exception {
        return new Response().success(postService.getPostById(postId));
    }

    @RequestMapping(value = "/delete-post", method = RequestMethod.POST)
    public Response deletePost(@RequestBody Long postId) throws Exception {
        postService.deletePost(postId);
        return new Response().success();
    }

    @RequestMapping(value = "/update-post", method = RequestMethod.POST)
    public Response updatePost(@RequestBody Post post) throws Exception {
        postService.updatePost(post);
        return new Response().success();
    }

    @RequestMapping(value = "/add-post", method = RequestMethod.POST)
    public Response addPost(@RequestBody Post post) throws Exception {
        postService.addPost(post);
        return new Response().success();
    }

    @RequestMapping(value = "/check-post", method = RequestMethod.POST)
    public Response checkPost(@RequestBody String postName) throws Exception {
        return new Response().success(postService.checkPost(postName));
    }

    @RequestMapping(value = "/delete-by-parent", method = RequestMethod.POST)
    public Response deleteByParent(@RequestBody Long departId) throws Exception {
        postService.deleteByParent(departId);
        return new Response().success();
    }
}
