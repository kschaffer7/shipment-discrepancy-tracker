package org.launchcode.shipmentdiscrepancytracker.controllers;

import org.launchcode.shipmentdiscrepancytracker.data.DiscrepancyRepository;
import org.launchcode.shipmentdiscrepancytracker.data.SupplierRepository;
import org.launchcode.shipmentdiscrepancytracker.models.Discrepancy;
import org.launchcode.shipmentdiscrepancytracker.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("discrepancies")
public class DiscrepancyController {

    //@Autowired tells spring boot to auto populate discrepancyRepository (dependency injection)
    @Autowired
    private DiscrepancyRepository discrepancyRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping
    public String displayAllDiscrepancies(Model model) {
        model.addAttribute("title", "All Discrepancies");
        model.addAttribute("discrepancies", discrepancyRepository.findAll());
        return "discrepancies/index";
    }

    // lives at /discrepancies/add
    @GetMapping("add")
    public String renderAddDiscrepancyForm(Model model) {
        model.addAttribute(new Discrepancy());
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "discrepancies/add";
    }

    // lives at /discrepancies/add
    @PostMapping("add")
    public String processAddDiscrepancyForm(@ModelAttribute @Valid Discrepancy discrepancy, Errors errors, Model model, @RequestParam int supplierId) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Discrepancy");
            model.addAttribute(new Discrepancy());
            model.addAttribute("suppliers", supplierRepository.findAll());
            return "discrepancies/add";
        }
        Optional optSupplier = supplierRepository.findById(supplierId);
        Supplier supplier = (Supplier) optSupplier.get();
        discrepancy.setSupplier(supplier);
        discrepancyRepository.save(discrepancy);
        return "redirect:";
    }

}
