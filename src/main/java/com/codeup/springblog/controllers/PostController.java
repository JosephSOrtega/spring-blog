package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.AdImage;
import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Models.PostCategory;
import com.codeup.springblog.Models.User;
import com.codeup.springblog.Repos.CategoryRepository;
import com.codeup.springblog.Repos.ImageRepository;
import com.codeup.springblog.Repos.PostRepository;
import com.codeup.springblog.Repos.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final CategoryRepository catDao;
    private final ImageRepository imgDao;
    private final EmailService emailService;


    public PostController(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository, ImageRepository imageRepository, EmailService emailService) {
        this.postDao = postRepository;
        this.userDao = userRepository;
        this.catDao = categoryRepository;
        this.imgDao = imageRepository;
        this.emailService = emailService;
    }
//
//    @Autowired
//    private EmailService emailService;


    @GetMapping("/posts")
    public String postsAll(Model vmodel) {
        List<Post> posts = null;

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

    //    @PostMapping("/posts/edited")
//    public String postsEdited(@ModelAttribute Post post) {
//        Post newPost = postDao.findOne(post.getId());
//        newPost.setTitle(post.getTitle());
//        newPost.setBody(post.getBody());
//        postDao.save(newPost);
//        return "posts/show";
//    }
    @PostMapping("/posts/edited")
    public String postsEdited(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            @RequestParam(name = "images") String images,
            @RequestParam(name = "categories") List<PostCategory> categories
    ) {

        Post newPost = postDao.findOne(id);
        newPost.setTitle(title);
        newPost.setBody(body);
        postDao.save(newPost);
        System.out.println("Post Added");
        AdImage savedImg = new AdImage();

        savedImg.setPath(images);
        savedImg.setId(id);
        imgDao.save(savedImg);
        System.out.println("IMG Added");




        for (PostCategory cat : categories) {
            postDao.insertNewCat(cat.getId(), newPost.getId());
        }
        System.out.println("Cat Added");


        return "redirect:/posts/" + newPost.getId();
    }


    @GetMapping("/posts/editing")
    public String postsToBeEdited(@ModelAttribute Post post, Model vModel) {
        Long newId = post.getId();
        vModel.addAttribute("post", postDao.findOne(newId));
        vModel.addAttribute("categories", catDao.findAll());
        vModel.addAttribute("images", imgDao.findOne(newId));


        return "posts/edit";
    }


    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", catDao.findAll());

        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            @RequestParam(name = "images") String images,
            @RequestParam(name = "categories") List<PostCategory> categories
    ) {

        Post savedPost = new Post();
        AdImage savedImg = new AdImage();
        savedPost.setOwner(userDao.findOne(1L));
        savedPost.setTitle(title);
        savedPost.setBody(body);

        postDao.save(savedPost);

        System.out.println("Post Added");

//        savedImg.setPath(images);
//        savedImg.setPost(postDao.findByTitle(title));
//        imgDao.save(savedImg);

        imgDao.save(images, postDao.findByTitle(title).getId());

        System.out.println("IMG Added");

        for (PostCategory cat : categories) {
            postDao.insertNewCat(cat.getId(), savedPost.getId());
        }
        System.out.println("Cat Added");

        emailService.prepareAndSend(postDao.findByTitle(savedPost.getTitle()), "Post Created", String.format("Post with id %s has been created.", savedPost.getId()));

        return "redirect:/posts";
    }

}


//TODO: Add loop to pop tags -- after setting tags as an arrtib for create page -- Model form binding