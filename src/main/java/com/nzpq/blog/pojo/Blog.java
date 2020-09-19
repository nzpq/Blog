package com.nzpq.blog.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 博客实体类
 */
@Data
public class Blog implements Serializable {

    private Long id;//主键id
    private String title;//博客标题
    private String content;//博客内容
    private String firstPicture;//博客详情页的图片
    private String flag;//博客标记：原创，转载，翻译
    private Integer views;//访问次数
    private String description;//描述
    private boolean appreciation;//是否开启赞赏
    private boolean shareStatement;//是否开启转载声明
    private boolean commentabled;//是否允许评论
    private boolean recommend;//是否推荐
    private boolean published;//是否发布
    private Date createTime;//创建时间
    private Date updateTime;//修改时间


    private Long typeId;//对应的博客id
    private Type type;//该博客对应的类型

    private List<Tag> tags;//该博客对应的标签

    private Long userId;//对应的用户id
    private UserInfo userInfo;//博客对应的作者，也就是管理员

    private List<Comment> comments;//该博客对应的评论

}
