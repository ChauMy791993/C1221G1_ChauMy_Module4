package codegym.controller;

import codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping(value = "/")
    public String goHomePage() {
        return "index";
    }

    @PostMapping(value = "/save")
    public String calculator(@RequestParam String number1, String number2, String operator, Model model) {
        model.addAttribute("result", this.iCalculatorService.calculator(number1, number2, operator.charAt(0)));
        return "index";
    }

}
