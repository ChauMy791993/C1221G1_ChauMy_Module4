package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult,Model model) {
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            iUserService.save(user);
            model.addAttribute("message", "register" + user.getFirstName() + " " + user.getLastName() + "successful !");
            return "redirect:/user";
        }
    }
}
