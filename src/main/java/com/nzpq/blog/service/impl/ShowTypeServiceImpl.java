package com.nzpq.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.nzpq.blog.mapper.IndexMapper;
import com.nzpq.blog.pojo.Type;
import com.nzpq.blog.service.ShowTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTypeServiceImpl implements ShowTypeService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<Type> listTypes(){
        return indexMapper.listTypes(null);
    };
}
