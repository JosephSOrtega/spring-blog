package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CategoryRepository extends JpaRepository<PostCategory, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "delete from spring_adlister_db.ad_images a where a.post_id = ?", nativeQuery = true)
    void deletePostCategoryBy(Long id);
    @Transactional
    @Modifying
    @Query(value = "delete from spring_adlister_db.posts_categories  where post_id = ?1", nativeQuery = true)
    void deletePostCategoriesByPost_id(Long id);


}
