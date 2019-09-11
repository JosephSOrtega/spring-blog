package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.AdImage;
import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Models.PostCategory;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
//    Custom:
    Post findByTitle(String title);
    List<PostCategory> findAllByCategories (List<PostCategory> postCategories);

    @Modifying
    @Query(value = "Insert into spring_adlister_db.ad_images (path, post_id) VALUES (?1, ?2);", nativeQuery = true)
    void insertNewImages(@Param("path") String path, @Param("post_id") Long post_id);


    @Modifying
    @Query(value = "Insert into spring_adlister_db.posts_categories (category_id, post_id) VALUES (?1, ?2);", nativeQuery = true)
    void insertNewCat(@Param("category_id") Long category_id, @Param("post_id") Long post_id);

//    @Query(value = "Select * from spring_adlister_db.categories;", nativeQuery = true)
//    List<PostCategory> allCategories();
//

}


