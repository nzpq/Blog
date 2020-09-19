package com.nzpq.blog.service;

import com.nzpq.blog.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByBlogId(Long id);

    void saveComments(Comment comment);
}
