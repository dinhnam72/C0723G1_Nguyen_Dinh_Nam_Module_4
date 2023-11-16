package com.example.bt1.controller;

import com.example.bt1.model.EmailBox;
import com.example.bt1.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailBoxController {
    @Autowired
    private IEmailBoxService emailBoxService;

    @ModelAttribute("language")
    public String[] getListLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] getListPageSize() {
        return new int[]{5, 10, 15, 25, 50, 100};
    }

    @GetMapping("")
    public String display(Model model) {
        List<EmailBox> emailBoxList = emailBoxService.display();
        model.addAttribute("emailBoxList", emailBoxList);
        return "list";
    }

    @GetMapping("update/{id}")
    public String checkId(@PathVariable(value = "id") int id, Model model) {
        EmailBox emailBox = emailBoxService.checkById(id);
        model.addAttribute("emailBox", emailBox);
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute EmailBox emailBox, RedirectAttributes attributes) {
        emailBoxService.update(emailBox);
        attributes.addFlashAttribute("mess", "Cập nhật dữ liệu thành công!");
        return "redirect:/email";
    }
}
