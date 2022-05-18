package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogRest")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/listBlog")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 7) Pageable pageable) {
        Page<Blog> blogPage = iBlogService.findAll(pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> findBlogByIdOfCategory(@PathVariable Integer id) {
        List<Blog> blogs = iBlogService.findBlogByCategory_Id(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createBlog (@RequestBody Blog blog){
        iBlogService.save(blog);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @PatchMapping("/edit")
    public ResponseEntity<Void> updateBlog (@RequestBody Blog blog){
       iBlogService.save(blog);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id){
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iBlogService.delete(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
