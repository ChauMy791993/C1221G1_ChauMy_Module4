package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);



    void save(Blog blog);

    void delete(Blog blog);

    void update (Blog blog);

    Blog findById (int id);

    List<Blog> findBlogByCategory_Id(Integer id);


}
