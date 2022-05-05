package codegym.controller;

import codegym.model.Email;
import codegym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    IEmailService   iEmailService;

    @GetMapping(value = "/settings")
    public String goSettings(Model model) {
        model.addAttribute("email", new Email());
        return "settings";
    }

    @GetMapping(value = "/list")
    public String goList (Model model){
        model.addAttribute("emailList",iEmailService.getList());
        return "list";
    }
    @PostMapping(value = "update")
    public String updateMail (@ModelAttribute Email email, RedirectAttributes redirectAttributes){
        iEmailService.save(email);
        redirectAttributes.addFlashAttribute("message","successfully");
        return "redirect:/settings";
    }

}
