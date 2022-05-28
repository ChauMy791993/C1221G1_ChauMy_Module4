package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.model.AttachService;
import com.codegym.model.Contract;
import com.codegym.model.ContractDetail;
import com.codegym.service.IAttachServiceService;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachServiceService iAttachServiceService;

    @ModelAttribute("contractList")
    public List<Contract> getContractList() {
        return iContractService.findAll();
    }

    @ModelAttribute("attachServiceList")
    public List<AttachService> getAttachServiceList() {
        return iAttachServiceService.findAll();
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "contract/create-contract-detail";
    }

    @PostMapping("/save")
    public String saveContractDetail(@Validated ContractDetailDto contractDetailDto, BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "contract/create-contract-detail";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            iContractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("message", "Save contract-detail successfully");
            return "redirect:/contract/list";
        }
    }

}
