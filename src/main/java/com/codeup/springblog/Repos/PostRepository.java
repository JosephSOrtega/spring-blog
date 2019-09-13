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
import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
//    Custom:
Post findByTitle(String title);
//    List<PostCategory> findAllByCategories (List<PostCategory> postCategories);



    @Modifying
    @Query(value = "Insert into spring_adlister_db.posts_categories (category_id, post_id) VALUES (:category_id, :post_id);", nativeQuery = true)
    @Transactional
    void insertNewCat(@Param("category_id") Long category_id, @Param("post_id") Long post_id);

    @Modifying
    @Query(value = "Insert into spring_adlister_db.ad_images (path) VALUES (:pathHere);", nativeQuery = true)
    @Transactional
    void insertNewImg (@Param("pathHere") String path);

    @Query(value = "SELECT path from spring_adlister_db.ad_images where post_id = :post_id;", nativeQuery = true)
    String findPathByPost_Id (Long post_id);



    @Modifying
    @Query(value = "insert into spring_adlister_db.ad_images (path, post_id) VALUES (:pathHere, :post_id);", nativeQuery = true)
    void saveImage(@Param("pathHere") String path, @Param("post_id") Long post_id);

//    @Query(value = "Select * from spring_adlister_db.categories;", nativeQuery = true)
//    List<PostCategory> allCategories();
//

}


