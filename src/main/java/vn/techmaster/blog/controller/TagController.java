package vn.techmaster.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.blog.DTO.UserInfo;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.service.IAuthenService;
import vn.techmaster.blog.service.ITagService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TagController {

    @Autowired
    ITagService tagService;

    @Autowired
    IAuthenService authenService;

    @GetMapping("/tag/{id}")
    public String getPostByTag(@PathVariable("id") Long id, Model model, HttpServletRequest request){
        UserInfo user = authenService.getLoginedUser(request);
        if (user != null) {  //Người dùng đã login
            model.addAttribute("user", user);
        }
        List<Post> allPosts = tagService.getAllPostsByTagId(id);
        model.addAttribute("posts", allPosts);
        return Route.HOME;
    }
}
