package com.nzpq.blog.config;

import com.nzpq.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Spring Security配置类
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginService loginService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/login").permitAll()
            .antMatchers("/admin/**").hasRole("ADMIN");

        http.formLogin().loginPage("/login").loginProcessingUrl("/toLogin").failureUrl("/login?error");

        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
        http.rememberMe();

    }

    /**
     * 认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 过滤静态资源
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/lib/**", "/css/**",  "/images/**", "/js/**");
    }
}
