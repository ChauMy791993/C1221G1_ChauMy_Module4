package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.dto.CustomerDto;
import com.codegym.model.Contract;
import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Facility;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute("employeeList")
    public List<Employee> getEmployeeList(){
        return this.iEmployeeService.findAll();
    }

    @ModelAttribute("customerList")
    public List<Customer> getCustomerList(){
        return this.iCustomerService.findAll();
    }

    @ModelAttribute("facilityList")
    public List<Facility> getFacilityList(){
        return this.iFacilityService.findAll();
    }

    @GetMapping("/list")
    public String getListContract(Model model, @PageableDefault(value=3) Pageable pageable, RedirectAttributes redirectAttributes){
        Page<Contract> contractPage = iContractService.findAll(pageable);
        model.addAttribute("contractList",contractPage);
        redirectAttributes.addFlashAttribute("message","");
        return "/contract/list";
    }

    @GetMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "/contract/create";
    }

    @PostMapping(value = "/save")
    public String saveContract(@Validated ContractDto contractDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            iContractService.save(contract);
            redirectAttributes.addFlashAttribute("message", "Save contract successfully");
            return "redirect:/contract/list";
        }
    }
}
