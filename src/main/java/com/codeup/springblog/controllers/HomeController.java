package com.codeup.springblog.controllers;
//package com.codeup.springblog.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class HomeController {
//    @GetMapping("/")
//    @ResponseBody
//    public String sayHello() {
//        return "This is the landing page!";
//    }
//
//}
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
}
