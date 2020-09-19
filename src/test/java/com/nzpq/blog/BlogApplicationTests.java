package com.nzpq.blog;

import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.service.IndexService;
import com.nzpq.blog.service.LoginService;
import com.nzpq.blog.service.admin.BlogService;
import com.nzpq.blog.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private LoginService loginService;
    @Autowired
    private BlogService blogService;

    @Autowired
    private IndexService indexService;
/*
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;
*/
    @Test
    void contextLoads() {
        UserDetails test = loginService.loadUserByUsername("test");
        System.out.println(test);
    }

    @Test
    void test(){
        blogService.findBlogTagsId(6L);
    }

    @Test
    void test2(){
        String s = "正确做好任何一件事情的前提是清晰、正确的理解目标。而事实是，我们很多人很多时候根本没有对目标正确的定义，甚至根本从来就没有想过，只是大家都那么做而已";
        System.out.println(s.length());
    }

    @Test
    void test3(){
        List<Blog> blogs = indexService.listBlog(1, 5, null);
        System.out.println(blogs.get(0));
    }

    /**
     * opsForValue()    操作字符串
     * opsForList()     操作list
     */
    /*
    @Test
    void testRedis(){
        redisTemplate.opsForValue().set("key","中文");
        Object key = redisTemplate.opsForValue().get("key");

        redisUtil.set("hh","hello");
        Object key2 = redisUtil.get("hh");

        System.out.println(key);
        System.out.println(key2);
    }
    */

}
