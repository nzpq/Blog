package com.nzpq.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.nzpq.blog.pojo.Tag;
import com.nzpq.blog.service.admin.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagsController {

    @Autowired
    private TagService tagService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询所有标签
     * @param page 页码
     * @param size 每页显示数量
     * @param model
     * @return
     */
    @GetMapping("/tags")
    public String tags(@RequestParam(name="page",defaultValue = "1") Integer page,
                       @RequestParam(name ="size",defaultValue = "8") Integer size, Model model){

        List<Tag> tags = tagService.listTag(page, size);
        PageInfo<Tag> info = new PageInfo<>(tags);
        model.addAttribute("info",info);

        return "admin/tags";
    }

    /**
     * 跳转到添加标签页面
     * @return
     */
    @GetMapping("/tag")
    public String toAddTag(){
        return "admin/tags-input";
    }

    /**
     * 完成添加一个标签
     * @param tag
     * @return
     */
    @PostMapping("/tag")
    public String saveTag(Tag tag,RedirectAttributes attributes){
        try {
            tagService.saveTag(tag);
            attributes.addFlashAttribute("resultMsg","标签添加成功！");
        } catch (Exception e) {
            attributes.addFlashAttribute("resultMsg","标签添加失败！");
            logger.error(e.getMessage());
        }
        return "redirect:/admin/tags";
    }

    /**
     * 判断要添加的标签是否已存在
     * @param name
     * @return
     */
    @GetMapping("/checkTag")
    @ResponseBody
    public Tag checkTagName(String name){
        Tag tag = tagService.getTagByName(name);
        return tag;
    }

    /**
     * 携带信息跳转到更新标签的页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/tag/{id}")
    public String toUpdateTag(@PathVariable("id") Long id,Model model){
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag",tag);
        return "admin/tags-input";
    }

    /**
     * 完成修改
     * @param tag
     * @return
     */
    @PutMapping("/tag")
    public String updateTag(Tag tag,RedirectAttributes attributes){
        try {
            tagService.updateTag(tag);
            attributes.addFlashAttribute("resultMsg","标签修改成功！");
        } catch (Exception e) {
            attributes.addFlashAttribute("resultMsg","标签修改失败！");
            logger.error(e.getMessage());
        }
        return "redirect:/admin/tags";
    }

    /**
     * 完成删除
     * @param id
     * @return
     */
    @DeleteMapping("/tag/{id}")
    public String deleteTag(@PathVariable("id") Long id,RedirectAttributes attributes){
        try {
            tagService.deleteTag(id);
            attributes.addFlashAttribute("resultMsg","标签删除成功！");
        } catch (Exception e) {
            attributes.addFlashAttribute("resultMsg","标签删除失败！");
            logger.error(e.getMessage());
        }
        return "redirect:/admin/tags";
    }



}
