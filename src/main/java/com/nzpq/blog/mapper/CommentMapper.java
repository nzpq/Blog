package com.nzpq.blog.mapper;

import com.nzpq.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    List<Comment> getCommentsByBlogId(Long id);

    void saveComments(Comment comment);

    Comment findOne(Long id);
}
