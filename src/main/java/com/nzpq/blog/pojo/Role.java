package com.nzpq.blog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色
 */
@Data
public class Role implements Serializable {
    private Integer id;
    private String roleName;
}
