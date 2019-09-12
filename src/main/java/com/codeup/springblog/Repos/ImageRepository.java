package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.AdImage;
import com.codeup.springblog.Models.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.ResultSet;

@Repository
public interface ImageRepository extends JpaRepository<AdImage, Long> {

//    @Modifying
//    @Query(value = "update spring_adlister_db.ad_images set post_id = ?1 where id = ?2", nativeQuery = true)
//    void insertNewImages(@Param("post_id") Long post_id, @Param("id") Long id);
//    @Modifying
//    @Query(value = "insert into spring_adlister_db.ad_images (path, post_id) select (:pathHere, :path_id)", nativeQuery = true)

    @Transactional
    @Modifying
    @Query(value = "update spring_adlister_db.ad_images a set a.path = ? where a.post_id = ?", nativeQuery = true)
    void saveNewImage(String path, Long id);

    AdImage findAdImageByPath(String path);
//    void saveNewImage(String path, Long id);
}
