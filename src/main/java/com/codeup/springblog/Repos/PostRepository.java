package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    //save();
//    delete();
//    findAll();
//    findOne();
//    Custom:
    Post findByTitle(String title);
//   the above = select * from ads where title is ?
    Post deleteById (Long id);
}


