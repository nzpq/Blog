package com.nzpq.blog.mapper;

import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.pojo.Tag;
import com.nzpq.blog.pojo.Type;
import com.nzpq.blog.vo.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IndexMapper {
    /**
     * 分页查询所有，根据参数条件查询，模糊查询
     * @return
     */
    List<Blog> listBlog(@Param("query") String query);

    /**
     * 根据id查询一个
     * @param id
     * @return
     */
    Blog getBlog(Long id);

    /**
     * 首页展示分类
     * @param size 首页显示几条分类信息，如果没有，则查询所有
     * @return
     */
    List<Type> listTypes(@Param("size") Integer size);

    /**
     * 首页展示标签，封装对应的博客
     * @param size 首页显示几条标签信息，如果没有，则查询所有
     * @return
     */
    List<Tag> listTags(@Param("size") Integer size);

    /**
     *最多浏览的八个篇博客
     * @return
     */
    List<Blog> getTopBlogs(@Param("size") Integer size);

    /**
     * 博客访问量加一
     * @param blog
     */
    void updateView(Blog blog);

    /**
     * 根据分类id查询
     * @param id
     * @return
     */
    List<Blog> getByTypeId(Long id);

    /**
     * 根据标签id查询
     * @param id
     * @return
     */
    List<Blog> getByTagId(Long id);

    /**
     * 查询所有博客对应的年份
     * @return
     */
    List<String> findGroupYear();

    /**
     * 根据年份分组查询
     * @param year
     * @return
     */
    List<Blog> findByYear(String year);

    /**
     * 查询博客总记录数
     * @return
     */
    Long findTotalBlog();
}
