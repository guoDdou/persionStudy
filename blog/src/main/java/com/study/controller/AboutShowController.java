package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutShowController {
//关于我的信息
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
