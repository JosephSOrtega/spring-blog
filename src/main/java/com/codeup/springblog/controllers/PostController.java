package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsAll(Model vmodel) {
        List<Post> posts = new ArrayList<>();
        Post postOne = new Post();
        postOne.setBody("Apples are delicious");
        postOne.setTitle("Apples!");

        Post postTwo = new Post();
        postTwo.setBody("Oranges are delicious");
        postTwo.setTitle("Oranges!");

        posts.add(postOne);
        posts.add(postTwo);

        vmodel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsAll(@PathVariable Long id, Model vmodel) {
        vmodel.addAttribute("id", id);
        Post postOne = new Post();
        postOne.setId(id);
        postOne.setBody("Apples are delicious");
        postOne.setTitle("Apples!");
        vmodel.addAttribute("post", postOne);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostForm() {
        return "posts/show";
    }

    @PostMapping("/posts/create")
    public String createPost() {
        return "posts/show";
    }

}
