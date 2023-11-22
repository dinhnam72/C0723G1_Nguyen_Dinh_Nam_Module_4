package com.example.bt.controller;

import com.example.bt.model.Blog;
import com.example.bt.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
   @GetMapping("")
   public String display(Model model){
       List<Blog> blogList=blogService.findAll();
       model.addAttribute("blogList",blogList);
       return "list";
   }

   @GetMapping("create")
   public String created(@ModelAttribute Blog blog, Model model){
       model.addAttribute("blog",blog);
       return "create";
   }
    @PostMapping("create")
    public String created(@ModelAttribute Blog blog, Model model,RedirectAttributes redirectAttributes){
       blogService.add(blog);
        return "redirect:/blog";
    }
   @GetMapping("update/{id}")
    public String update(@PathVariable("id") int id,Model model){
       Blog blog = blogService.findById(id);
       model.addAttribute("blog",blog);
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
