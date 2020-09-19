package com.nzpq.blog.mapper.admin;

import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.vo.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogMapper {

    Blog getBlog(Long id);

    List<Blog> listBlog(BlogQuery blogQuery);

    void saveBlog(Blog blog);

    void deleteBlog(Long id);

    void updateBlog(Blog blog);
    /**
     * 向博客-标签中间表插入数据
     * @param tid 标签id
     * @Param uid 作者id
     */
    void addBlogTags(@Param("tid") Long tid, @Param("bid") Long bid);

    void deleteBlogTags(Long id);

    void updatePublished(Long id);

    List<Long> findBlogTagsId(Long id);
}
