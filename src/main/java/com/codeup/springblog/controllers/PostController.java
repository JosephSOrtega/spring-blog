package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postRepository) {
        postDao = postRepository;
    }

    @GetMapping("/posts")
    public String postsAll(Model vmodel) {
//        List<Post> posts = new ArrayList<>();
        List<Post> posts;

//        Post postOne = new Post();
//        postOne.setId(1L);
//        postOne.setBody("Apples are delicious");
//        postOne.setTitle("Apples!");
//
//        Post postTwo = new Post();
//        postOne.setId(2L);
//        postTwo.setBody("Oranges are delicious");
//        postTwo.setTitle("Oranges!");


//        posts.add(postOne);
//        posts.add(postTwo);
//

        posts = (List<Post>) postDao.findAll();

        vmodel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsOne(@PathVariable Long id, Model vmodel) {
        vmodel.addAttribute("id", id);
        Post postOne;
//        postOne.setId(1L);
//        postOne.setBody("Apples are delicious");
//        postOne.setTitle("Apples!");
        postOne = postDao.findOne(id);
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
