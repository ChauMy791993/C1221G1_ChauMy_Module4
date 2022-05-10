package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> finAll();

    void save(Blog blog);

    void delete(Blog blog);

    void update (Blog blog);

    Blog findById (int id);

    List<Blog> findAllByBlogTitle (String title);

}
