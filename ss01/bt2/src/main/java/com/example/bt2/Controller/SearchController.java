package com.example.bt2.Controller;

import com.example.bt2.Serivce.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @Autowired
    private ISearchService searchService;
    @GetMapping(value = "search")
    public String display(){
        return "dictionary";
    }
    @PostMapping(value = "search")
    public String result(@RequestParam String keyWord, Model model){
        String result = searchService.result(keyWord);
        String error ="Từ này không có trong hệ thống";
        model.addAttribute("keyWord",keyWord);
        model.addAttribute("result",result);
        model.addAttribute("error",error);
        return "dictionary";
    }
}
