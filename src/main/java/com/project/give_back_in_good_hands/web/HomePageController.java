package com.project.give_back_in_good_hands.web;

import com.project.give_back_in_good_hands.domain.Institution;
import com.project.give_back_in_good_hands.service.DonationService;
import com.project.give_back_in_good_hands.service.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomePageController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomePageController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping(value = "/")
    public String index(Model model){
        List<Institution> institutionList = institutionService.institutions();
        model.addAttribute("institutions",institutionList);
        long sumOffAll = donationService.sumOffAll();
        model.addAttribute("sumOffAll", sumOffAll);
        return "index";
    }
}
