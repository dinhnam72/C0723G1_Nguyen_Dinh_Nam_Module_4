package com.example.bt1.controller;

import com.example.bt1.model.Product;
import com.example.bt1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/list")
    public String display(Model model){
        model.addAttribute("productList",productService.findAll());
        return "/product/list";
    }
    @GetMapping("/create")
    public String create(Product product, Model model){
        model.addAttribute("product",product);
        model.addAttribute("typeList",new String[]{"Nước giải khát","Đồ ăn"});
        return "/product/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
       productService.save(product);
       redirectAttributes.addFlashAttribute("mess","Thêm mới thành công!");
        return "redirect:/product/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable ("id") int id,Model model){
        Product product = productService.checkById(id);
        model.addAttribute("product",product);
        return "/product/detail";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable ("id") int id,Model model){
        Product product = productService.checkById(id);
        model.addAttribute("product",product);
        model.addAttribute("typeList",new String[]{"Nước giải khát","Đồ ăn"});
        return "/product/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công!");
        return "redirect:/product/list";
    }
    @GetMapping("/remove")
    public String remove(@RequestParam int id,RedirectAttributes redirectAttributes){
        productService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công!");
        return "redirect:/product/list";
    }
    @PostMapping("/search")
    public String search(@RequestParam String nameSearch,Model model){
       List<Product> productList= productService.searchByName(nameSearch);
       model.addAttribute("nameSearch",nameSearch);
       model.addAttribute("productList",productList);
        return "/product/list";
    }
}
