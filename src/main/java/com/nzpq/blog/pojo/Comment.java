package com.nzpq.blog.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 评论
 */
@Data
public class Comment {

    private Long id;
    private String nickName;//昵称
    private String email;
    private String content;//评论的内容
    private String avatar;//头像地址
    private Date createTime;//评论的时间

    private Blog blog;//该条评论对应的博客
    private boolean adminComment;//是否博主

    private List<Comment> replyComments;//对应一条评论下边的回复

    private Comment parentComment;//相同级别的评论

}
