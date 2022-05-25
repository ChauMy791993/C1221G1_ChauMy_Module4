package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Employee;
import com.codegym.model.Position;
import com.codegym.service.IDivisionService;
import com.codegym.service.IEducationDegreeService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;

    @ModelAttribute("positionList")
    public List<Position> getPositionList() {
        return iPositionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> getEducationDegreeList() {
        return iEducationDegreeService.findAll();
    }

    @ModelAttribute("divisionList")
    public List<Division> getDivisionList() {
        return iDivisionService.findAll();
    }

    @GetMapping("/list")
    public String getListEmployee(Model model, @PageableDefault(value = 3) Pageable pageable,
                                  @RequestParam Optional<String> employeeName,
                                  @RequestParam Optional<String> employeeAddress,
                                  @RequestParam Optional<String> position,
                                  RedirectAttributes redirectAttributes) {

        String keywordVal1 = employeeName.orElse("");
        String keywordVal2 = employeeAddress.orElse("");
        String keywordVal3 = position.orElse("");
        model.addAttribute("keyword1", keywordVal1);
        model.addAttribute("keyword2", keywordVal2);
        model.addAttribute("keyword3", keywordVal3);
        model.addAttribute("employeeList", iEmployeeService.findAllByEmployee
                (keywordVal1, keywordVal2, keywordVal3, pageable));
        redirectAttributes.addFlashAttribute("message", "");
        return "/employee/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "/employee/create";
    }

    @PostMapping("/save")
    public String saveEmployee(@Validated EmployeeDto employeeDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("message","save successfully");
            return "redirect:/employee/list";
        }

    }
}

