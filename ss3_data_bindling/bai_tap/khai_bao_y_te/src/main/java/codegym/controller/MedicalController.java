package codegym.controller;

import codegym.model.Medical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {

    @GetMapping("/")
    public String goFormMedical (Model model){
        model.addAttribute("medical",new Medical());
        return "form";
    }

    @PostMapping("/create")
    public String saveMedical (@ModelAttribute Medical medical,Model model){
        model.addAttribute("medicalList",medical);
        return "info";
    }
    @PostMapping ("edit")
    public String editMediacal (@ModelAttribute ("medicalList") Medical medical,Model model){
        model.addAttribute("medical",medical);
        return "form";
    }

}
