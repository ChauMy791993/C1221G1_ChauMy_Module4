package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {


//@Query(value="select * from blog_list where blog_title like :title_search",nativeQuery =true)
//    List<Blog> findAllByBlogTitle(@Param("title_search") String title);
List<Blog> findBlogByCategory_Id(Integer id);
}
