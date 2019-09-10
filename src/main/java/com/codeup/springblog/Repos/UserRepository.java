package com.codeup.springblog.Repos;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}


