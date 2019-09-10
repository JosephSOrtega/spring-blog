package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Repos.PostRepository;
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

//    @GetMapping("/posts/{id}/delete")
//    public String postsDelete(@PathVariable Long id) {
//        postDao.deletePostById(id);
//        return "posts/show";
//    }

//    @GetMapping("/posts/{id}/delete")
//    public String postsDelete(@PathVariable Long id) {
//        Post post = postDao.findOne(id);
//        postDao.delete(post.getId());
//        return "posts/delete";
//    }

    @PostMapping("/posts/delete")
    public String postsToBeDelete(@ModelAttribute Post post) {
//        Post post = postDao.findOne(id);

//        postDao.delete(post.getId());

        Long delId = post.getId();
        postDao.delete(delId);

//        return "posts/delete";
        return "redirect:/posts";

    }

//    @GetMapping("/posts/{id}/edit")
//    public String postsEditForm(@PathVariable Long id, Model vModel) {
//        vModel.addAttribute("post", postDao.findOne(id));
//        return "posts/edit";
//    }

    @PostMapping("/posts/edited")
    public String postsEdited(@ModelAttribute Post post) {
        Post newPost = postDao.findOne(post.getId());
        newPost.setTitle(post.getTitle());
        newPost.setBody(post.getBody());
        postDao.save(newPost);
//        postDao.updatePost(newPost.getTitle(), newPost.getBody(), id);
        return "posts/show";
    }

    @GetMapping("/posts/editing")
    public String postsToBeEdited(@ModelAttribute Post post, Model vModel) {
//        Post newPost =  postDao.findOne(post.getId());
//        newPost.setTitle(post.getTitle());
//        newPost.setBody(post.getBody());
//        postDao.save(newPost);
//        postDao.updatePost(newPost.getTitle(), newPost.getBody(), id);
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
        Post newPost = new Post();
        if (post != null) {
            newPost.setTitle(post.getTitle());
            newPost.setBody(post.getBody());
            postDao.save(newPost);
        }

        return "redirect:/posts";
    }

}
