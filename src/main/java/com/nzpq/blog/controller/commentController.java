package com.nzpq.blog.controller;

import com.nzpq.blog.pojo.Comment;
import com.nzpq.blog.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class commentController {

    @Autowired
    private CommentService commentService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 加载博客对应的留言
     * @return
     */
    @GetMapping("/comment/{id}")
    public String getComments(@PathVariable(name = "id") Long id,Model model){
        List<Comment> comments = commentService.getCommentsByBlogId(id);
        for (Comment comment : comments) {
            System.out.println("===》"+comment);
        }
        model.addAttribute("comments",comments);
        return "blog :: commentList";
    }


    @PostMapping("/comment")
    public String addComment(Comment comment){

        commentService.saveComments(comment);
//        logger.info(comment.toString());

        return "redirect:/comment/"+comment.getBlog().getId();
    }
}
