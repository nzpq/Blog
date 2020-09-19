package com.nzpq.blog.service.impl;

import com.nzpq.blog.mapper.IndexMapper;
import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArchivesServiceImpl implements ArchivesService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public Map<String, List<Blog>> archiveBlog(){
        List<String> years = indexMapper.findGroupYear();
        Map<String,List<Blog>> map = new HashMap<>();
        for(String year : years){
            List<Blog> blogs = indexMapper.findByYear(year);
            map.put(year,blogs);
        }
        return map;
    }

    @Override
    public Long countBlog() {
        return indexMapper.findTotalBlog();
    }
}
