package com.nzpq.blog.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.nzpq.blog.mapper.admin.TypeMapper;
import com.nzpq.blog.pojo.Type;
import com.nzpq.blog.service.admin.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public void saveType(Type type) {
         typeMapper.saveType(type);
    }

    @Override
    public Type getType(Long id) {
        return typeMapper.getType(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public List<Type> listType(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return typeMapper.listType();
    }

    @Override
    public void updateType(Type type) {
         typeMapper.updateType(type);
    }

    @Override
    public void deleteType(Long id) {
        typeMapper.deleteType(id);
    }

    @Override
    public List<Type> listType() {
        return typeMapper.listType();
    }
}
