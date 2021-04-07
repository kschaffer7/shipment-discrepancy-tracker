package org.launchcode.shipmentdiscrepancytracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("discrepancies")
public class DiscrepancyListController {

    @GetMapping
    public String displayAllDiscrepancies(Model model) {
        List<String> discrepancies = new ArrayList<>();
        discrepancies.add("INV505");
        discrepancies.add("SI-202");
        discrepancies.add("INV-1011");
        discrepancies.add("I123554");
        model.addAttribute("discrepancies", discrepancies);
        model.addAttribute("title", "All Discrepancies");
        return "discrepancies/index";
    }

    // lives at /discrepancies/add
    @GetMapping("add")
    public String renderAddDiscrepancyForm() {
        return "discrepancies/add";
    }

}
