package com.example.bt.controller;

import com.example.bt.model.Blog;
import com.example.bt.service.IBlogService;
import com.example.bt.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
   @GetMapping("")
   public String display(@RequestParam (defaultValue = "0") int page,
                         @RequestParam(defaultValue = "") String searchName,
                         @RequestParam(defaultValue = "0") int categoryId,
                         Model model){
       Pageable pageable = PageRequest.of(page,3,Sort.by("date_of_writing").ascending());
       Page<Blog> blogPage = blogService.findAll(pageable,searchName,categoryId);
       model.addAttribute("blogPage",blogPage);
       model.addAttribute("searchName",searchName);
       model.addAttribute("categoryId",categoryId);
       model.addAttribute("categoryList",categoryService.findAll());
       return "list";
   }
   @GetMapping("create")
   public String created(@ModelAttribute Blog blog, Model model){
       model.addAttribute("blog",blog);
       model.addAttribute("categoryList",categoryService.findAll());
       return "create";
   }
    @PostMapping("create")
    public String created(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
       blogService.add(blog);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công!");
        return "redirect:/blog";
    }
   @GetMapping("update/{id}")
    public String update(@PathVariable("id") int id,Model model){
       Blog blog = blogService.findById(id);
       model.addAttribute("blog",blog);
       model.addAttribute("categoryList",categoryService.findAll());
       return "update";
   }
    @PostMapping("update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
       blogService.update(blog);
       redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công!");
        return "redirect:/blog";
    }
    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") int id,Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }
    @GetMapping("remove")
    public String remove(@RequestParam("id") int id,RedirectAttributes redirectAttributes){
         blogService.remove(id);
       redirectAttributes.addFlashAttribute("mess","Xóa thành công!");
        return "redirect:/blog";
    }
}
