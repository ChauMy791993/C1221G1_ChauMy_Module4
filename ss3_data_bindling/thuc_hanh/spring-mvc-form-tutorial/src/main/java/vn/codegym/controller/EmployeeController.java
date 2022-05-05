package vn.codegym.controller;

import vn.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("employee/")
public class EmployeeController {
    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm (Model model){
        model.addAttribute("employee",new Employee());
        return "employee/create";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String sumbit (@ModelAttribute Employee employee,Model model){
        model.addAttribute("employee",employee);
        return "employee/info";
    }
    


}
