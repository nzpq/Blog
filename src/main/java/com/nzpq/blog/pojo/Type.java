package com.nzpq.blog.pojo;

import lombok.Data;

import java.util.List;

/**
 * 分类实体类
 */
@Data
public class Type {
    private Long id;
    private String name;

    private List<Blog> blogs;//该分类下对应的博客
}
