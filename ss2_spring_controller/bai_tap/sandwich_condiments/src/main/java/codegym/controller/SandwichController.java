package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping(value = "/")
    public String goIndex() {
        return "index";
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(@RequestParam("condiments") String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("condimentList",condiment);
        return modelAndView;
    }
}


