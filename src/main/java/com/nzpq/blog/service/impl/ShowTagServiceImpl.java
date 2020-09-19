package com.nzpq.blog.service.impl;

import com.nzpq.blog.mapper.IndexMapper;
import com.nzpq.blog.pojo.Tag;
import com.nzpq.blog.service.ShowTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTagServiceImpl implements ShowTagService {

    @Autowired
    private IndexMapper indexMapper;
    @Override
    public List<Tag> listTags() {

        return indexMapper.listTags(null);
    }
}
