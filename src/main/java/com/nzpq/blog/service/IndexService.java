package com.nzpq.blog.service;

import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.pojo.Tag;
import com.nzpq.blog.pojo.Type;
import com.nzpq.blog.vo.BlogQuery;

import java.util.List;

public interface IndexService {
    /**
     * 分页查询所有，根据参数条件查询，模糊查询
     * @return
     */
    List<Blog> listBlog(Integer page, Integer size, String query);

    /**
     * 根据id查询一个
     * @param id
     * @return
     */
    Blog getBlog(Long id);

    /**
     * 获取到一个博客并将内容转为html
     * @param id
     * @return
     */
    Blog getBlogToHtml(Long id);

    /**
     * 首页展示分类
     * @param size 首页显示几条分类信息，如果没有，则查询所有
     * @return
     */
    List<Type> listTypes(Integer size);

    /**
     * 首页展示标签
     * @param size 首页显示几条标签信息，如果没有，则查询所有
     * @return
     */
    List<Tag> listTags(Integer size);

    /**
     *获取最新的八个博客
     * @return
     */
    List<Blog> getTopBlogs(Integer size);

    /**
     * 根据分类id查询
     * @param id
     * @return
     */
    List<Blog> getByTypeId(Long id,Integer page,Integer size);

    /**
     * 根据详情id查询
     * @param id
     * @return
     */
    List<Blog> getByTagId(Long id,Integer page,Integer size);
}
