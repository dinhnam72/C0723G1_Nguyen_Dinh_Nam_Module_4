package com.example.bt.controller;

import com.example.bt.model.Cart;
import com.example.bt.model.Product;
import com.example.bt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Product product = productService.findById(id);
        if (product==null) {
            return "/error";
        }
        if (action.equals("add")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }else if (action.equals("remove")){
            cart.removeProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }
    @GetMapping("/remove/{id}")
    public String removeToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Product product = productService.findById(id);
        if (product==null) {
            return "/error";
        }
        if (action.equals("remove")){
            cart.removeProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }

}
