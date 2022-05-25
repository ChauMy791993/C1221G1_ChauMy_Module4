package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public String getListCustomer(Model model, @PageableDefault(value = 3) Pageable pageable,
                          @RequestParam Optional<String> customerName, RedirectAttributes redirectAttributes) {
        String keywordVal = customerName.orElse("");
        model.addAttribute("customerList", iCustomerService.findAllByCustomerNameContaining(keywordVal, pageable));
        model.addAttribute("keyword", keywordVal);
        redirectAttributes.addFlashAttribute("message", "");
        return "/customer/list";
    }


    @GetMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@Validated CustomerDto customerDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Save customer successfully");
            return "redirect:/customer/list";
        }
    }


    @PostMapping(value = "/delete")
    public String deleteCustomer(Integer id, RedirectAttributes redirectAttributes) {
        Customer customer = iCustomerService.findById(id);
        iCustomerService.delete(customer);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/customer/list";
    }

    @GetMapping("/detail")
    public String detailForm(Model model, int id) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/customer/detail";
    }


    @GetMapping("/edit")
    public String editFrom(Model model, int id) {
        Customer customer = iCustomerService.findById(id);
        if (customer == null) {
            return "error";
        } else {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerType", iCustomerTypeService.findAll());
            return "/customer/edit";
        }

    }


    @PostMapping("/edit")
    public String editCustomer(@Validated CustomerDto customerDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            return "/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "update successfully");
            return "redirect:/customer/list";
        }
    }

}
