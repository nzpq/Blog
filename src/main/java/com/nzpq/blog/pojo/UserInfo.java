package com.nzpq.blog.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 管理员实体类，或者称为作者
 */
@Data
@Component
public class UserInfo {
    private Long id;
    private String nickName;//昵称
    private String username;//用户名
    private String password;//密码
    private String email;
    private String avatar;//头像地址
    private Integer type;//用户类型，后期含义是：角色id
    private Date createTime;//创建的时间
    private Date updateTime;//更新的时间

    private List<Blog> blogs;//作者对应的博客
    private List<Role> roles;//对应的角色

}
