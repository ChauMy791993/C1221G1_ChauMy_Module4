package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SessionAttributes("cart")
@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto cartDto() {
        return new CartDto();
    }

    @GetMapping("/")
    public String listProduct(@PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Product> products = iProductService.findAll(pageable);
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/add/{id}")
    public String addToCard(@PathVariable Integer id, @SessionAttribute("cart") CartDto cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = Optional.ofNullable(iProductService.findById(id));
        if (!productOptional.isPresent()) {
            return "/error";
        }
        ProductDto productDto = null;
        if (action.equals("show")) {
            productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cart.minusProduct(productDto);
            return "redirect:/shopping-cart";
        }
        cart.minusProduct(productDto);
        return "redirect:/shop";
    }
    @GetMapping("/{id}/view")
    public String view (@PathVariable int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "view";
    }
}
