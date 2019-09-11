package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<PostCategory, Long> {
}
