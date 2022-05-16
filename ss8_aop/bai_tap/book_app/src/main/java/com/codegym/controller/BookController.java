package com.codegym.controller;

import com.codegym.service.IBookService;
import com.codegym.service.IBorrowBookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowBookCodeService iBorrowBookCodeService;

    @GetMapping("/")
    public String getList (Model model){
        model.addAttribute("bookList",iBookService.findAll());
        return "list";
    }
//    @GetMapping
}
