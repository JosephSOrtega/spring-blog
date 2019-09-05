package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{numone}/and/{numtwo}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int numone, @PathVariable int numtwo) {

        return "<h1>" + (numone + numtwo)+ "</h1>";
    }
    @RequestMapping(path = "/subtract/{numone}/from/{numtwo}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int numone, @PathVariable int numtwo) {
        return "<h1>"+ (numone - numtwo) + "<h1>";
    }
    @RequestMapping(path = "/multiply/{numone}/and/{numtwo}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int numone, @PathVariable int numtwo) {
        return "<h1>"+ (numone * numtwo) + "<h1>";
    }
    @RequestMapping(path = "/divide/{numone}/by/{numtwo}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int numone, @PathVariable int numtwo) {
        return "<h1>"+ (numone/numtwo) + "<h1>";
    }

}
