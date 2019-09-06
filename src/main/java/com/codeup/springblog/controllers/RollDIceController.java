package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class RollDIceController {

    @GetMapping("/roll-dice")
    public String welcomeUser() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{num}")
    public String roller(@PathVariable String num, Model vmodel) {
        int nums = Integer.parseInt(num);
        int number = (int)(Math.random() * (nums) + 1);
        vmodel.addAttribute("number", number);
        vmodel.addAttribute("guess", nums);
        return "roll-dice";
    }

}

