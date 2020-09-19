package com.nzpq.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {



    @Bean //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //视图映射

                registry.addViewController("/admin/login").setViewName("admin/login");//进入到后代管理登录页面
                registry.addViewController("/admin/blogs").setViewName("admin/blogs");
            }

        };
        return configurer;
    }
}
