package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.BorrowBookCode;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowBookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowBookCodeService iBorrowBookCodeService;

    @GetMapping("/")
    public String getList(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String getDetailBook(@RequestParam String id, Model model) {
        Book book = iBookService.findById(id);
        model.addAttribute("book", book);
        return "detail";
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam String id, Model model, RedirectAttributes redirectAttributes) {
        Book book = iBookService.findById(id);
        if (book.getQuantity() <= 0) {
            model.addAttribute("msg", "library is out of book !");
            return "error";
        } else {
            book.setQuantity(book.getQuantity() - 1);
            BorrowBookCode borrowBookCode = new BorrowBookCode();
            String code = String.valueOf(Math.round(Math.random() * 89999 + 10000));
            BorrowBookCode existBorrowBookCode = iBorrowBookCodeService.findById(code);
            while (existBorrowBookCode != null) {
                code = String.valueOf(Math.round(Math.random() * 89999 + 10000));
            }
            borrowBookCode.setCode(code);
            borrowBookCode.setBook(book);
            iBorrowBookCodeService.save(borrowBookCode);
            redirectAttributes.addFlashAttribute("message", "borrow book successfully");
            return "redirect:/list";
        }
    }

    @GetMapping("/giveBack")
    public String giveBackBook(@RequestParam String id,Model model,RedirectAttributes redirectAttributes){
        BorrowBookCode borrowBookCode = iBorrowBookCodeService.findById(id);
        if(borrowBookCode == null){
            model.addAttribute("msg","code is not exist");
            return "error";
        }else {
            Book book= borrowBookCode.getBook();
            book.setQuantity(book.getQuantity()+1);
            iBorrowBookCodeService.delete(borrowBookCode);
            redirectAttributes.addFlashAttribute("message","give back successfully");
            return "redirect:/list";
        }
    }

    @ExceptionHandler (Exception.class)
    public String showErrorPage (){
        return "error";
    }
}
