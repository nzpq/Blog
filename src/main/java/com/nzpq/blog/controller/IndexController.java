package com.nzpq.blog.controller;

import com.github.pagehelper.PageInfo;
import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.pojo.Tag;
import com.nzpq.blog.pojo.Type;
import com.nzpq.blog.service.IndexService;
import com.nzpq.blog.vo.BlogQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ConfigurationProperties(prefix = "size")
public class IndexController {

    @Autowired
    private IndexService indexService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${size.typeSize}")
    Integer typeSize;
    @Value("${size.tagSize}")
    Integer tagSize;
    @Value("${size.blogSize}")
    Integer blogSize;

    /**
     * 携带信息跳转到博客首页
     * @param model
     * @return
     */
    @GetMapping({"","/"})
    public String index(@RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "10") Integer size,
                        Model model){

        //博客列表
        List<Blog> blogs = indexService.listBlog(page, size, null);
        PageInfo<Blog> info = new PageInfo<>(blogs);
        //分类列表
        List<Type> types = indexService.listTypes(typeSize);
        //标签列表
        List<Tag> tags = indexService.listTags(tagSize);
        //最多浏览的十篇博客
        List<Blog> topBlogs = indexService.getTopBlogs(blogSize);
        model.addAttribute("info",info);
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("topBlogs",topBlogs);

        return "index";
    }

    /**
     * 全局搜索
     * @param page 页码
     * @param size 展示数量
     * @param query 搜索参数
     * @param model
     * @return
     */
    @GetMapping("/search")
    public String searchBlog(@RequestParam(name = "page",defaultValue = "1") Integer page,
                             @RequestParam(name = "size",defaultValue = "10") Integer size,
                             Model model,@RequestParam(name = "query") String query){

        List<Blog> blogs = indexService.listBlog(page, size, query);
        PageInfo<Blog> info = new PageInfo<>(blogs);
        model.addAttribute("info",info);
        model.addAttribute("query",query);
        return "search";
    }

    /**
     * 博客详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable(name = "id")Long id,Model model){
        Blog blog = indexService.getBlogToHtml(id);
        model.addAttribute("blog",blog);
        return "blog";
    }

    @RequestMapping("/register")
    public String register(){

        return "register";
    }

    @RequestMapping("/aboutMe")
    public String about(){

        return "about";
    }
}
