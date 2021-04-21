package org.launchcode.shipmentdiscrepancytracker.controllers;


import org.launchcode.shipmentdiscrepancytracker.data.ReceivingClerkRepository;
import org.launchcode.shipmentdiscrepancytracker.models.ReceivingClerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("receivingClerks")
public class ReceivingClerkController {

    @Autowired
    private ReceivingClerkRepository receivingClerkRepository;

    @GetMapping
    public String listReceivingClerks(Model model) {
        model.addAttribute("title", "All Receiving Clerks");
        model.addAttribute("receivingClerks", receivingClerkRepository.findAll());
        return "receivingClerks/index";
    }

    @GetMapping("add")
    public String displayAddReceivingClerkForm(Model model) {
        model.addAttribute("title", "Add Receiving Clerk");
        model.addAttribute(new ReceivingClerk());
        return "receivingClerks/add";
    }

    @PostMapping("add")
    public String processAddReceivingClerkForm(@ModelAttribute @Valid ReceivingClerk receivingClerk, Errors errors, Model model) {
        if (errors.hasErrors()) {
            System.out.println("ERROR HERE");
            model.addAttribute("title", "Add Receiving Clerk");
            model.addAttribute(new ReceivingClerk());
            return "receivingClerks/add";
        }
        receivingClerkRepository.save(receivingClerk);
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
