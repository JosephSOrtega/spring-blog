package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.AdImage;
import com.codeup.springblog.Models.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.ResultSet;

public interface ImageRepository extends JpaRepository<AdImage, Long> {
    @Modifying
    @Query(value = "update spring_adlister_db.ad_images set post_id = ?1 where id = ?2", nativeQuery = true)
    void insertNewImages(@Param("post_id") Long post_id, @Param("id") Long id);
    @Query(value = "insert into spring_adlister_db.ad_images (path, post_id) select (?1, ?2)", nativeQuery = true)
    ResultSet save(@Param("path") String path, @Param("post_id") Long id);
    AdImage findAdImageByPath(String path);
//    void saveNewImage(String path, Long id);
}
