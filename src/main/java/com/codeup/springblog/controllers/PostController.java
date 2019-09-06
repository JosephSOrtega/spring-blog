package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsAll() {
        return"<h1>Posts Index Page<h1>" +
                "<h2>Here are all the posts:<h2>" +
                "<ul>" +
                "<li>1</li>" +
                "<li>1</li>" +
                "<li>1</li>" +
                "</ul>";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsAll(@PathVariable Long id) {
        return "Here is Posts Page "+id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "View the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a new post";
    }

}