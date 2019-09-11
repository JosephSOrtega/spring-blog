package com.codeup.springblog.Models;

import com.sun.xml.internal.xsom.impl.scd.Step;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.util.List;

@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;
    @OneToOne
    private User owner;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
//    private List<AdImage> images;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private String images;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_categories",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<PostCategory> categories;


    // needs new instance
    public Post() {
    }

    //    The R in CRUD, Constructors
//    public Post(Long id, String title, String body, User owner, List<AdImage> images, List<PostCategory> categories) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//        this.owner = owner;
//        this.images = images;
//        this.categories = categories;
//    }
    public Post(Long id, String title, String body, User owner, String images, List<PostCategory> categories) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
        this.images = images;
        this.categories = categories;
    }

    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public List<AdImage> getImages() {
        return images;
    }

    public void setImages(List<AdImage> images) {
        this.images = images;
    }

    public void setOwner(User owner) {
        this.owner = owner;

    }

    public List<PostCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PostCategory> categories) {
        this.categories = categories;
    }
}
