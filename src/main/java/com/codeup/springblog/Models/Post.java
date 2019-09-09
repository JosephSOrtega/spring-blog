package com.codeup.springblog.Models;

import com.sun.xml.internal.xsom.impl.scd.Step;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.soap.Text;

//@Controller
@Entity (name = "Posts")
public
class Post {

    @Id @GeneratedValue
    Long id;
    @Column (nullable = false, length = 255)
    String title;
    @Column (nullable = false, columnDefinition = "TEXT")
    String body;

    public Post() {
    }

    public Post(Long id, String title, String body) {
        this.id = id;
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


}
