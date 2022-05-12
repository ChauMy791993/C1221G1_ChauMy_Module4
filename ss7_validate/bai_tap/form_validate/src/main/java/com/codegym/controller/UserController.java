package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.GeneratedValue;
import javax.servlet.RequestDispatcher;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/user")
    public String getList(Model model, @PageableDefault(value = 2) Pageable pageable,
                          @RequestParam Optional<String> firstName, RedirectAttributes redirectAttributes) {
        String keywordVal = firstName.orElse("");
        model.addAttribute("userList", iUserService.findAllByFirstNameContaining(keywordVal, pageable));
        model.addAttribute("keyword", keywordVal);
        redirectAttributes.addFlashAttribute("message", "");
        return "list";
    }

    @GetMapping("/create")
    public String saveForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        iUserService.save(user);
        redirectAttributes.addFlashAttribute("message", "save user successfully");
        return "redirect:/user";
    }

}
