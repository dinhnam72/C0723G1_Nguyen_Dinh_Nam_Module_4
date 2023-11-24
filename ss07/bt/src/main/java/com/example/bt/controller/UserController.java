package com.example.bt.controller;

import com.example.bt.model.User;
import com.example.bt.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public String result(){
        return "result";
    }
    @GetMapping("create")
    public String create(@ModelAttribute User user, Model model){
        model.addAttribute("user",user);
        return "index";
    }
    @PostMapping("create")
    public String create(@Valid @ModelAttribute User user, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        new User().validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return "index";
        }
        userService.add(user);
        redirectAttributes.addFlashAttribute("mess","Account added successfully!");
        return "redirect:/user";
    }
}
