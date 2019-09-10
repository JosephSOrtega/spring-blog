package com.codeup.springblog.Models;

import javax.persistence.*;

@Entity
@Table(name="ad_images")
public class AdImage {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn (name = "ad_id")
    private Post post;
}
