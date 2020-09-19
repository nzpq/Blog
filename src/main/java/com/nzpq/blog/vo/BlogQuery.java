package com.nzpq.blog.vo;

import lombok.Data;

/**
 * 对应后台管理的搜索框
 */
@Data
public class BlogQuery {

    private String title;
    private Long typeId;
    private boolean recommend;
}
