package com.nzpq.blog.service.admin;

import com.nzpq.blog.pojo.Type;

import java.util.List;

public interface TypeService {

    /**
     * 保存一个分类
     * @param type
     * @return
     */
    void saveType(Type type);

    /**
     * 根据id查询一个分类
     * @param id
     * @return
     */
    Type getType(Long id);

    /**
     * 根据名字查询一个分类
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 查询所有，分页展示
     * @param page 页码
     * @param size 每页展示的数量
     * @return
     */
    List<Type> listType(Integer page,Integer size);

    /**
     * 更新
     * @param type
     * @return
     */
    void updateType(Type type);

    /**
     * 删除一个分类
     * @param id
     */
    void deleteType(Long id);

    /**
     * 查询所有，不分页
     * @return
     */
    List<Type> listType();
}
