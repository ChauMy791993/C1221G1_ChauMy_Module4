package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> finAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public Category findById(int id) {
        return null;
    }


}
