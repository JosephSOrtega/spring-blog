package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.Post;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    //save();
//    delete();
//    findAll();
//    findOne();
//    Custom:
    Post findByTitle(String title);

    //   the above = select * from ads where title is ?
//    @Query("delete from Post post where post.id = :id")
//    void deletePostById(@Param("id") Long id);

//    @Modifying
//    @Query("update Post post set post.title = ?1, post.body = ?2 where post.id = ?3")
//    void updatePost(String title, String body, Long id);

}


