package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
//save();
//    delete();
}
