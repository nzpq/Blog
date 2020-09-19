package com.nzpq.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.nzpq.blog.pojo.Type;
import com.nzpq.blog.service.admin.TypeService;
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
public class TypeController {

    @Autowired
    private TypeService typeService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询所有分类
     * @param page 页码
     * @param size 每页显示数量
     * @param model
     * @return
     */
    @GetMapping("/types")
    public String types(@RequestParam(name="page",defaultValue = "1") Integer page,
                        @RequestParam(name ="size",defaultValue = "8") Integer size, Model model){

        List<Type> types = typeService.listType(page, size);
        PageInfo<Type> info = new PageInfo<>(types);
        model.addAttribute("info",info);

        return "admin/types";
    }

    /**
     * 跳转到添加分类页面
     * @return
     */
    @GetMapping("/type")
    public String toAddTypes(){
        return "admin/types-input";
    }

    /**
     * 添加一个分类
     * @return
     */
    @PostMapping("/type")
    public String addTypes(Type type, RedirectAttributes attributes){
        try {
            typeService.saveType(type);
            attributes.addFlashAttribute("resultMsg","添加成功！");
        } catch (Exception e) {
            attributes.addFlashAttribute("resultMsg","添加失败！");
            logger.error(e.getMessage());
        }
        return "redirect:/admin/types";
    }

    /**
     * 判断数据库中是否已有该分类名
     * @param name 分类名
     * @return
     */
    @GetMapping("/checkType")
    @ResponseBody
    public Type checkType(String name){
        Type type = typeService.getTypeByName(name);
        return type;
    }

    /**
     * 携带要修改的分类信息跳转到修改页面
     * @param id 分类的id
     * @param model
     * @return
     */
    @GetMapping("/type/{id}")
    public String toUpdate(@PathVariable("id") Long id,Model model){
        Type type = typeService.getType(id);
        model.addAttribute("type",type);
        return "admin/types-input";
    }

    /**
     * 修改一个分类
     * @param type
     * @return
     */
    @PutMapping("/type")
    public String updateType(Type type,RedirectAttributes attributes){
        try {
            typeService.updateType(type);
            attributes.addFlashAttribute("resultMsg","修改成功！");
        } catch (Exception e) {
            attributes.addFlashAttribute("resultMsg","修改失败！");
            logger.error(e.getMessage());
        }
        return "redirect:/admin/types";
    }

    /**
     * 删除一个分类
     * @param id
     * @return
     */
    @DeleteMapping("/type/{id}")
    public String deleteType(@PathVariable("id") Long id,RedirectAttributes attributes){
        try {
            typeService.deleteType(id);
            attributes.addFlashAttribute("resultMsg","删除成功！");
        } catch (Exception e) {
            attributes.addFlashAttribute("resultMsg","删除失败！");
           logger.error(e.getMessage());
        }
        return "redirect:/admin/types";
    }


}
