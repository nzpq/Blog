package com.nzpq.blog.mapper;

import com.nzpq.blog.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginMapper {

    UserInfo findByUsername(String username);
}
