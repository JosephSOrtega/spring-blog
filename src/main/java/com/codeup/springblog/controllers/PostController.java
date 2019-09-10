package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Models.User;
import com.codeup.springblog.Repos.PostRepository;
import com.codeup.springblog.Repos.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postDao = postRepository;
        this.userDao = userRepository;
    }

    @GetMapping("/posts")
    public String postsAll(Model vmodel) {
        List<Post> posts;

        posts = (List<Post>) postDao.findAll();

        vmodel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsOne(@PathVariable Long id, Model vmodel) {
        vmodel.addAttribute("id", id);
        Post postOne;
        postOne = postDao.findOne(id);
        vmodel.addAttribute("post", postOne);

        return "posts/show";
    }

    @PostMapping("/posts/delete")
    public String postsToBeDelete(@ModelAttribute Post post) {
        Long delId = post.getId();
        postDao.delete(delId);
        return "redirect:/posts";

    }

    @PostMapping("/posts/edited")
    public String postsEdited(@ModelAttribute Post post) {
        Post newPost = postDao.findOne(post.getId());
        newPost.setTitle(post.getTitle());
        newPost.setBody(post.getBody());
        postDao.save(newPost);
        return "posts/show";
    }

    @GetMapping("/posts/editing")
    public String postsToBeEdited(@ModelAttribute Post post, Model vModel) {
        Long newId = post.getId();
        vModel.addAttribute("post", postDao.findOne(newId));

        return "posts/edit";
    }


    @GetMapping("/posts/create")
    public String createPostForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {

//hardcoded for now
        User userDB = userDao.findOne(1L);


        Post newPost = new Post();
        if (post != null) {
            newPost.setTitle(post.getTitle());
            newPost.setBody(post.getBody());
            newPost.setOwner(userDB);
            postDao.save(newPost);
        }

        return "redirect:/posts";
    }

}
