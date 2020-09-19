package com.nzpq.blog.mapper.admin;

import com.nzpq.blog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TagMapper {
    /**
     * 保存一个标签
     * @param tag
     * @return
     */
    void saveTag(Tag tag);

    /**
     * 根据id查询一个标签
     * @param id
     * @return
     */
    Tag getTag(Long id);

    /**
     * 根据名字查询一个标签
     * @param name
     * @return
     */
    Tag getTagByName(String name);

    /**
     * 查询所有，分页展示
     * @return
     */
    List<Tag> listTag();

    /**
     * 更新
     * @param tag
     * @return
     */
    void updateTag(Tag tag);

    /**
     * 删除一个标签
     * @param id
     */
    void deleteTag(Long id);

}
