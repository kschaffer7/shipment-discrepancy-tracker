package org.launchcode.shipmentdiscrepancytracker.controllers;


import org.launchcode.shipmentdiscrepancytracker.data.SupplierRepository;
import org.launchcode.shipmentdiscrepancytracker.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("suppliers")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping
    public String listSuppliers(Model model) {
        model.addAttribute("title", "All Suppliers");
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "suppliers/index";
    }

    @GetMapping("add")
    public String displayAddSupplierForm(Model model) {
        model.addAttribute("title", "Add Supplier");
        model.addAttribute(new Supplier());
        return "suppliers/add";
    }

    @PostMapping("add")
    public String processAddSupplierForm(@ModelAttribute @Valid Supplier supplier, Errors errors, Model model) {
        if (errors.hasErrors()) {
            System.out.println("ERROR HERE");
            model.addAttribute("title", "Add Supplier");
            model.addAttribute(new Supplier());
            return "suppliers/add";
        }
        supplierRepository.save(supplier);
        return "redirect:/discrepancies/add";
    }

//    @GetMapping("view/{supplierId}")
//    public String displayViewSupplier(Model model, @PathVariable int supplierId) {
//
//        Optional optSupplier = supplierRepository.findById(supplierId);
//        if (optSupplier.isPresent()) {
//            Supplier supplier = (Supplier) optSupplier.get();
//            model.addAttribute("supplier", supplier);
//            return "suppliers/view";
//        } else {
//            return "redirect:../";
//        }
//    }
}
