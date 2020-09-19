package com.nzpq.blog.controller;

import com.github.pagehelper.PageInfo;
import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.pojo.Type;
import com.nzpq.blog.service.IndexService;
import com.nzpq.blog.service.ShowTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShowTypeController {

    @Autowired
    private ShowTypeService showTypeService;
    @Autowired
    private IndexService indexService;

    @GetMapping("/type")
    public String showType(@RequestParam(name = "page",defaultValue = "1") Integer page,
                           @RequestParam(name = "size",defaultValue = "10") Integer size,
                           @RequestParam(name = "id")Long id, Model model){
        List<Type> types = showTypeService.listTypes();
        if(id == -1){
            id =types.get(0).getId();
        }
        List<Blog> blogs = indexService.getByTypeId(id,page,size);
        PageInfo<Blog> info = new PageInfo<>(blogs);
        model.addAttribute("types",types);
        model.addAttribute("info",info);
        model.addAttribute("activeTypeId", id);
        return "types";
    }

}
