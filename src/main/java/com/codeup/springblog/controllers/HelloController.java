package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1>Hello from Spring!</h1>";
    }
    @PostMapping("/hello")
    @ResponseBody
    public String goodbye() {
        return "<h1>Goodbye from Spring!</h1>";
    }
    @GetMapping("/goodbye")
    @ResponseBody
    public String bye() {
        return "<h1>Bye from Spring!</h1>";
    }
}

