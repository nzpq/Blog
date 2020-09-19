package com.nzpq.blog.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.nzpq.blog.mapper.admin.TagMapper;
import com.nzpq.blog.pojo.Tag;
import com.nzpq.blog.service.admin.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void saveTag(Tag tag) {
        tagMapper.saveTag(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagMapper.getTag(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    public List<Tag> listTag(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return tagMapper.listTag();
    }

    @Override
    public void updateTag(Tag tag) {
        tagMapper.updateTag(tag);
    }

    @Override
    public void deleteTag(Long id) {
        tagMapper.deleteTag(id);
    }

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }


}
