package com.codegym.controller;

import com.codegym.service.ICurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverter {

    @Autowired
    private ICurrencyConverterService iCurrencyConverterService;

    @GetMapping(value = "/")
    public String goHomePage () {
        return "homepage";
    }

    @PostMapping(value = "/converter")
    public String currencyConverter (@RequestParam String usd, Model model){
        model.addAttribute("result",this.iCurrencyConverterService.converter(usd));
        return "homepage";
    }

}
