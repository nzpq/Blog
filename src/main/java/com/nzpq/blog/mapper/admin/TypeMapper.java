package com.nzpq.blog.mapper.admin;

import com.nzpq.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TypeMapper {

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
     * @return
     */
    List<Type> listType();

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
}
