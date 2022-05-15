package com.codegym.controller;


import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/")
    public String getList(Model model, @PageableDefault(value = 3) Pageable pageable,
                          @RequestParam Optional<String> name, RedirectAttributes redirectAttributes) {
        String keywordVal = name.orElse("");
        model.addAttribute("productList", iProductService.findAllByNameContaining(keywordVal,pageable));
        model.addAttribute("keyword",keywordVal);
        redirectAttributes.addFlashAttribute("message", "");
        return "list";
    }

    @GetMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }

    @PostMapping(value = "/save")
    public String saveProduct(@Validated ProductDto productDto, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if(bindingResult.hasFieldErrors()){
            return "create";
        }else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto,product);
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("message", "Save product successfully");
            return "redirect:/";
        }

    }

    @PostMapping(value = "/delete")
    public String deleteProduct(Product product, RedirectAttributes redirectAttributes) {
        iProductService.delete(product);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/";
    }

    @GetMapping("/view")
    public String viewForm(Model model, int id) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

    @GetMapping("/edit")
    public String editFrom(Model model, int id) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "update successfully");
        return "redirect:/";
    }

}
