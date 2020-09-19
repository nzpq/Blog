package com.nzpq.blog.pojo;

import lombok.Data;

import java.util.List;

/**
 * 标签类
 */
@Data
public class Tag {
    private Long id;
    private String name;

    private List<Blog> blogs;//该分类对应的博客
}
