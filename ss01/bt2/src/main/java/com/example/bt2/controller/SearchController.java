package com.example.bt2.controller;

import com.example.bt2.serivce.ISearchService;
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
        model.addAttribute("keyWord",keyWord);
        model.addAttribute("result",result);
        return "dictionary";
    }
}
