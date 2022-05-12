package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/blog")
    public String getList(Model model, @PageableDefault(value = 3) Pageable pageable,
                          @RequestParam Optional<String> title, RedirectAttributes redirectAttributes) {
        String keywordVal = title.orElse("");
        model.addAttribute("blogList", iBlogService.findAllByTitle(keywordVal,pageable));
        model.addAttribute("keyword",keywordVal);
        redirectAttributes.addFlashAttribute("message", "");
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.finAll());
        return "create";
    }

    @PostMapping("/save")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Save blog successfully");
        return "redirect:/blog";
    }

    @GetMapping("/view")
    public String viewBlog(Model model, int id) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";
    }

    @GetMapping("/edit")
    public String editForm(Model model, int id) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.finAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "update successfully");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String deleteBlog(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.delete(blog);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/blog";
    }


}


//    @GetMapping("/search")
//    public String searchBlog(Model model, @RequestParam String title) {
//        model.addAttribute("blogList", iBlogService.findAllByBlogTitle(title));
//        return "list";
//    }