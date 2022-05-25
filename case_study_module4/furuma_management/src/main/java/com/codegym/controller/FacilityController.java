package com.codegym.controller;

import com.codegym.dto.FacilityDto;
import com.codegym.model.Facility;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/list")
    public String getListFacility(Model model, @PageableDefault(value = 3) Pageable pageable,
                                  Optional<String> facilityName, RedirectAttributes redirectAttributes) {
        String keywordVal = facilityName.orElse("");
        model.addAttribute("facilityList", iFacilityService.findAllByFacilityNameContaining(keywordVal, pageable));
        model.addAttribute("keyword", keywordVal);
        redirectAttributes.addFlashAttribute("message", "");
        return "/facility/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        return "/facility/create";

    }

    @PostMapping("/save")
    public String saveFacility(@Validated FacilityDto facilityDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto,facility);
            iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("message","Save facility successfully");
            return "redirect:/facility/list";
        }
    }
}
