package com.codeup.springblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String sayHello() {
        return "This is the landing page!";
    }

}
