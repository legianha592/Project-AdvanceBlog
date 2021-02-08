package vn.techmaster.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.blog.DTO.UserInfo;
import vn.techmaster.blog.controller.request.CommentRequest;
import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.service.IAuthenService;
import vn.techmaster.blog.service.ICommentService;
import vn.techmaster.blog.service.IPostService;
import vn.techmaster.blog.service.PostException;

import java.util.Optional;

@Controller
public class CommentController {
  @Autowired
  private IAuthenService authenService;
  @Autowired
  private IPostService postService;
  @Autowired
  private ICommentService commentService;

  @PostMapping("/comment")
  public String handlePostComment(@ModelAttribute CommentRequest commentRequest, HttpServletRequest request) {
    UserInfo userLogin = authenService.getLoginedUser(request);
    if (userLogin != null) {
      try {
        postService.addComment(commentRequest, userLogin.getId());
      } catch (PostException e) {
        e.printStackTrace();
      }

      return "redirect:/post/" + commentRequest.getPost_id();

    } else {
      return Route.HOME;
    }
  }

  @PostMapping("/comment/delete")
  public String deleteComment(@RequestParam(name="comment_id") Long comment_id,
                              @RequestParam(name="post_id") Long post_id, HttpServletRequest request){
    System.out.println("comment id = " + comment_id);
    System.out.println("post id = " + post_id);
    Optional<Comment> comment = commentService.findById(comment_id);
    if (comment.isPresent()){
      commentService.deleteById(comment_id);
      return "redirect:/post/" + post_id;
    }
    return Route.ALLPOSTS;
  }
}
