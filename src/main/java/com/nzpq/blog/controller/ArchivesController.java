package com.nzpq.blog.controller;

import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ArchivesController {

    @Autowired
    private ArchivesService archivesService;

    @GetMapping("/archives")
    public String archivesBlog(Model model){
        Map<String, List<Blog>> map = archivesService.archiveBlog();
        Long total = archivesService.countBlog();
        model.addAttribute("map",map);
        model.addAttribute("total",total);
        return "archives";
    }
}
