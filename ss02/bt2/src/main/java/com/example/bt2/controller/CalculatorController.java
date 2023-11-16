package com.example.bt2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping(value = "/calculator")
    public String display(){
        return "calculator";
    }
    @PostMapping(value = "/calculator")
    public String result(@RequestParam double number1, @RequestParam double number2, @RequestParam String calculation, Model model){
        double result=0;
        String error=null;
        switch (calculation){
            case "+":
                result=number1+number2;
                break;
            case "-":
                result=number1-number2;
                break;
            case "*":
                result=number1*number2;
                break;
            default:
                try {
                    result=number1/number2;
                }catch (ArithmeticException  exception){
                     error = "Can't be divided by Zero";
                }

        }

        model.addAttribute("result",(double)Math.round(result*100)/100);
        model.addAttribute("error",error);
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        return "calculator";
    }
}
