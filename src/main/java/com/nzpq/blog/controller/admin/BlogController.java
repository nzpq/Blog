package com.nzpq.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.nzpq.blog.pojo.Blog;
import com.nzpq.blog.pojo.Tag;
import com.nzpq.blog.pojo.Type;
import com.nzpq.blog.service.admin.BlogService;
import com.nzpq.blog.service.admin.TagService;
import com.nzpq.blog.service.admin.TypeService;
import com.nzpq.blog.vo.BlogQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询所有博客，多条件搜索
     * @param page 页码
     * @param size 每页展示十条数据
     * @param model
     * @return
     */
    @GetMapping("/blogs")
    public String blogs(@RequestParam(name = "page",defaultValue = "0" )Integer page,
                        @RequestParam(name = "size",defaultValue = "10" )Integer size,
                        Model model){

        List<Blog> blogs = blogService.listBlog(page, size,null);
        //解决前端博客展示‘描述’这一字段时数据过长
//        for(Blog blog : blogs){
//            String description = blog.getDescription();
//            //输入描述超过十，就截取
//            if(description.length() >= 10){
//                String substring = description.substring(0, 20);
//                blog.setDescription(substring+"。。。");
//            }
//        }
        PageInfo<Blog> info = new PageInfo<>(blogs);
        //查询分类信息，用于前端搜索框数据回显
        List<Type> types = typeService.listType();
        model.addAttribute("info",info);
        model.addAttribute("types",types);
        return "admin/blogs";
    }

    /**
     * 搜索博客
     * @param page 页码
     * @param size 每页展示数量
     * @param blogQuery 搜索条件
     * @param model
     * @return
     */
    @PostMapping("/searchBlog")
    public String searchBlog(@RequestParam(name = "page",defaultValue = "0" )Integer page,
                             @RequestParam(name = "size",defaultValue = "10" )Integer size,
                             BlogQuery blogQuery,Model model){
        List<Blog> blogs = blogService.listBlog(page, size,blogQuery);
        PageInfo<Blog> info = new PageInfo<>(blogs);
        model.addAttribute("info",info);

//        logger.info(blogQuery.toString());
//        logger.info(page.toString());
        return "admin/blogs :: blogList";
    }

    /**
     * 跳转到写博客页面
     * 携带分类数据，标签数据
     * @return
     */
    @GetMapping("/blog")
    public String toAddBlog(Model model){
       setTypeAndTag(model);
        return "admin/blogs-input";
    }

    /**
     * 保存博客
     * @param blog
     * @param tagIds
     * @return
     */
    @PostMapping("/blog")
    public String addBlog(Blog blog,@RequestParam("tagIds") String tagIds){
//        blogService.saveBlog(blog,tagIds);
        System.out.println(tagIds);
        return "redirect:/admin/blogs";
    }

    /**
     * 发布博客，从草稿状态到发布状态
     * @param id
     * @return
     */
    @GetMapping("/publishBlog/{id}")
    public String publishBlog(@PathVariable(name = "id")Long id){
        blogService.publishBlog(id);
        return "redirect:/admin/blogs";
    }

    /**
     * 删除博客
     * @param id
     * @return
     */
    @DeleteMapping("/blog/{id}")
    public String deleteBlog(@PathVariable(name = "id")Long id){
        //先删除中间表的数据
        blogService.deleteBlogTags(id);
        blogService.deleteBlog(id);
        return "redirect:/admin/blogs";
    }

    /**
     * 携带信息跳转到更新页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/blog/{id}")
    public String toUpdateBlog(@PathVariable(name = "id")Long id,Model model){

        Blog blog = blogService.getBlog(id);
        //查询出该博客对应的标签id，用于回显数据
        String blogTagsId = blogService.findBlogTagsId(blog.getId());
//        logger.info(blog.toString());
        setTypeAndTag(model);
        model.addAttribute("blog",blog);
        model.addAttribute("tagIds",blogTagsId);
        return "admin/blogs-input";
    }

    @PutMapping("/blog")
    public String updateBlog(Blog blog,@RequestParam("tagIds") String tagIds){
        blogService.updateBlog(blog,tagIds);
        return "redirect:/admin/blogs";
    }

    /**
     * 查询出所有类型和所有标签
     * @param model
     */
    private void setTypeAndTag(Model model) {
        List<Tag> tags = tagService.listTag();
        List<Type> types = typeService.listType();

        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
    }


}
