package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

@Query(value="select * from blog_list where blog_title like :title_search",nativeQuery =true)
    List<Blog> findAllByBlogTitle(@Param("title_search") String title);

}
