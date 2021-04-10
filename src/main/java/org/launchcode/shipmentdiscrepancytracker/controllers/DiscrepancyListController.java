package org.launchcode.shipmentdiscrepancytracker.controllers;

import org.launchcode.shipmentdiscrepancytracker.data.DiscrepancyRepository;
import org.launchcode.shipmentdiscrepancytracker.models.Discrepancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("discrepancies")
public class DiscrepancyListController {

    //@Autowired tells spring boot to auto populate discrepancyRepository (dependency injection)
    @Autowired
    private DiscrepancyRepository discrepancyRepository;

    @GetMapping
    public String displayAllDiscrepancies(Model model) {
        model.addAttribute("title", "All Discrepancies");
        model.addAttribute("discrepancies", discrepancyRepository.findAll());
        return "discrepancies/index";
    }

    // lives at /discrepancies/add
    @GetMapping("add")
    public String renderAddDiscrepancyForm(Model model) {
        model.addAttribute("title", "Add Discrepancy");
        model.addAttribute(new Discrepancy());
        return "discrepancies/add";
    }

    // lives at /discrepancies/add
    @PostMapping("add")
    public String processAddDiscrepancyForm(@ModelAttribute @Valid Discrepancy discrepancy, Errors errors, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute(new Discrepancy());
            return "discrepancies/add";
        }
        discrepancyRepository.save(discrepancy);
        return "redirect:";
    }

}
