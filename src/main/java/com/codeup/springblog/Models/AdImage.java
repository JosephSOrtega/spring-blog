package com.codeup.springblog.Models;

import javax.persistence.*;

@Entity
@Table(name = "ad_images")
public class AdImage {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    public AdImage() {

    }

    public AdImage(String path, Post post) {
        this.path = path;
        this.post = post;
    }
    public AdImage(String path, long id) {
        this.path = path;
        this.id = id;
    }
    public AdImage(String path) {
        this.path = path;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
