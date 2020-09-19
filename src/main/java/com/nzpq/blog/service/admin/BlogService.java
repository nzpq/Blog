package com.nzpq.blog.service.admin;

import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.vo.BlogQuery;

import java.util.List;

public interface BlogService {

    Blog getBlog(Long id);

    List<Blog> listBlog(Integer page, Integer size,BlogQuery blogQuery);

    void saveBlog(Blog blog,String tagIds);

    void deleteBlog(Long id);

    void updateBlog(Blog blog,String tagIds);

    /**
     * 删除博客-标签中间表的数据
     * @param id 博客id
     */
    void deleteBlogTags(Long id);

    /**
     * 发布博客
     * @param id
     */
    void publishBlog(Long id);

    /**
     * 查询出该博客对应的标签id，用于回显数据
     * @param id
     */
    String findBlogTagsId(Long id);
}
