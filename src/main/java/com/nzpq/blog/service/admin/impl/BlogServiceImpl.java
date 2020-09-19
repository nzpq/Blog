package com.nzpq.blog.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.nzpq.blog.mapper.admin.BlogMapper;
import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.pojo.UserInfo;
import com.nzpq.blog.service.admin.BlogService;
import com.nzpq.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private  UserInfo userInfo;

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.getBlog(id);
    }

    @Override
    public List<Blog> listBlog(Integer page, Integer size,BlogQuery blogQuery) {
        PageHelper.startPage(page,size);
        return blogMapper.listBlog(blogQuery);
    }

    @Override
    public void saveBlog(Blog blog,String tagIds) {
        //封装其他信息
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        userInfo.setId(1L);
        blog.setUserInfo(userInfo);
        blogMapper.saveBlog(blog);

        //向博客-标签中间表插入数据
        if (!"".equals(tagIds) && tagIds != null) {

            String[] idarray = tagIds.split(",");
            for (String s : idarray) {
                blogMapper.addBlogTags(Long.valueOf(s), blog.getId());
            }
        }

    }

    @Override
    public void deleteBlog(Long id) {
        blogMapper.deleteBlog(id);
    }

    @Override
    public void updateBlog(Blog blog,String tagIds) {
        //封装其他信息
        blog.setUpdateTime(new Date());
        blogMapper.updateBlog(blog);

        //修改博客-标签中间表
        //先删除，在添加
        blogMapper.deleteBlogTags(blog.getId());
        if (!"".equals(tagIds) && tagIds != null) {

            String[] idarray = tagIds.split(",");
            for (String s : idarray) {
                blogMapper.addBlogTags(Long.valueOf(s), blog.getId());
            }
        }
    }

    @Override
    public void deleteBlogTags(Long id) {
        blogMapper.deleteBlogTags(id);
    }

    @Override
    public void publishBlog(Long id) {
        blogMapper.updatePublished(id);
    }

    @Override
    public String findBlogTagsId(Long id) {
        List<Long> tagsId = blogMapper.findBlogTagsId(id);
        //将List转为String
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < tagsId.size();i++){
            sb.append(tagsId.get(i));
            if(i != tagsId.size() - 1){
               sb.append(",");
            }
        }
        return sb.toString();
    }
}
