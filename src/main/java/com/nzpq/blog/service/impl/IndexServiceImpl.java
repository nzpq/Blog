package com.nzpq.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.nzpq.blog.exception.NotFoundException;
import com.nzpq.blog.mapper.IndexMapper;
import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.pojo.Tag;
import com.nzpq.blog.pojo.Type;
import com.nzpq.blog.service.IndexService;
import com.nzpq.blog.utils.MarkdownUtils;
import com.nzpq.blog.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<Blog> listBlog(Integer page,Integer size,String query) {
        PageHelper.startPage(page,size);
        return indexMapper.listBlog(query);
    }

    @Override
    public Blog getBlog(Long id) {
        return indexMapper.getBlog(id);
    }

    @Override
    public Blog getBlogToHtml(Long id) {
        Blog blog = indexMapper.getBlog(id);
        if (blog == null) {
            throw new NotFoundException("该博客不存在");
        }
        Blog b = new Blog();
        BeanUtils.copyProperties(blog,b);
        String content = b.getContent();
        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        //该博客访问量加一
        blog.setViews(blog.getViews() + 1);
        indexMapper.updateView(blog);
        return b;
    }

    @Override
    public List<Type> listTypes(Integer size) {
        return indexMapper.listTypes(size);
    }

    @Override
    public List<Tag> listTags(Integer size) {
        return indexMapper.listTags(size);
    }

    @Override
    public List<Blog> getTopBlogs(Integer size) {
        return indexMapper.getTopBlogs(size);
    }

    @Override
    public List<Blog> getByTypeId(Long id,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return indexMapper.getByTypeId(id);
    }

    @Override
    public List<Blog> getByTagId(Long id,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return indexMapper.getByTagId(id);
    }
}
