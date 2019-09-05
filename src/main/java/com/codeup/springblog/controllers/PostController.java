package com.codeup.springblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String postsAll() {
        return "Posts Index Page";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsAll(@PathVariable Long id) {
        return "Posts Page "+id;
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
