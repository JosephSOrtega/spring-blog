package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.AdImage;
import com.codeup.springblog.Models.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<AdImage, Long> {
//    @Modifying
//    @Query(value = "insert into a (path, post_id) VALUES (?1, ?2);", nativeQuery = true)
//    void insertNewImages(@Param("path") String path, @Param("post_id") Long post_id);

//    void save(String path, Long id);
}
