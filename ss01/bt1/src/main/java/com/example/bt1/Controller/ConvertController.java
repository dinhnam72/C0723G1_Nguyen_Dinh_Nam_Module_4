package com.example.bt1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping(value = "convert")
    public String display() {
        return "form-convert";
    }
    @PostMapping(value = "/convert")
    public String result(@RequestParam int usd, Model model) {
        int result = usd*23000;
        model.addAttribute("usd",usd);
        model.addAttribute("result",result);
        return "form-convert";
    }
}
