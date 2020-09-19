package com.nzpq.blog.service;

import com.nzpq.blog.mapper.LoginMapper;
import com.nzpq.blog.pojo.Role;
import com.nzpq.blog.pojo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginMapper loginMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = loginMapper.findByUsername(s);
//        logger.info("==》    "+userInfo);
        if(userInfo == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        //通过Spring security比较密码
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();//存储用户对应的角色
        for(Role role : userInfo.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new User(userInfo.getUsername(),userInfo.getPassword(),authorities);
    }
}
