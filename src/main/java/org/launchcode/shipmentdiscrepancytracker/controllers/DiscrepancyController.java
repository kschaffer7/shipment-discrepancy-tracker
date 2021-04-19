package org.launchcode.shipmentdiscrepancytracker.controllers;

import org.launchcode.shipmentdiscrepancytracker.data.DiscrepancyRepository;
import org.launchcode.shipmentdiscrepancytracker.data.ReceivingClerkRepository;
import org.launchcode.shipmentdiscrepancytracker.data.SupplierRepository;
import org.launchcode.shipmentdiscrepancytracker.models.Discrepancy;
import org.launchcode.shipmentdiscrepancytracker.models.ReceivingClerk;
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

    @Autowired
    private ReceivingClerkRepository receivingClerkRepository;

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
        model.addAttribute("receivingClerks", receivingClerkRepository.findAll());
        return "discrepancies/add";
    }

    // lives at /discrepancies/add
    @PostMapping("add")
    public String processAddDiscrepancyForm(@ModelAttribute @Valid Discrepancy discrepancy, Errors errors, Model model, @RequestParam int supplierId, @RequestParam int receivingClerkId) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Discrepancy");
            model.addAttribute(new Discrepancy());
            model.addAttribute("suppliers", supplierRepository.findAll());
            model.addAttribute("receivingClerks", receivingClerkRepository.findAll());
            return "discrepancies/add";
        }

        Optional optSupplier = supplierRepository.findById(supplierId);
        Supplier supplier = (Supplier) optSupplier.get();
        discrepancy.setSupplier(supplier);

        Optional optReceivingClerk = receivingClerkRepository.findById(receivingClerkId);
        ReceivingClerk receivingClerk = (ReceivingClerk) optReceivingClerk.get();
        discrepancy.setReceivingClerk(receivingClerk);

        discrepancyRepository.save(discrepancy);
        return "redirect:";
    }

    @GetMapping("edit/{discrepancyId}")
    public String displayEditDiscrepancy(Model model, @PathVariable int discrepancyId) {
        Optional optionalDiscrepancy = discrepancyRepository.findById(discrepancyId);
        Discrepancy discrepancy = (Discrepancy) optionalDiscrepancy.get();
        model.addAttribute("discrepancy", discrepancy);
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("receivingClerks", receivingClerkRepository.findAll());
        return "discrepancies/edit";
    }

    @PostMapping("edit/{discrepancyId}")
    public String processEditDiscrepancyForm(@ModelAttribute @Valid Discrepancy discrepancy, Errors errors, Model model, @RequestParam int supplierId, @RequestParam int receivingClerkId, @PathVariable int discrepancyId) {
        Discrepancy optionalDiscrepancy = discrepancyRepository.findById(discrepancyId).get();
        if(errors.hasErrors()) {
            model.addAttribute("title", "Edit Discrepancy");
            model.addAttribute("discrepancy", optionalDiscrepancy);
            model.addAttribute("suppliers", supplierRepository.findAll());
            model.addAttribute("receivingClerks", receivingClerkRepository.findAll());
            return "discrepancies/edit";
        }

        Optional optSupplier = supplierRepository.findById(supplierId);
        Supplier supplier = (Supplier) optSupplier.get();
        optionalDiscrepancy.setSupplier(supplier);

        Optional optReceivingClerk = receivingClerkRepository.findById(receivingClerkId);
        ReceivingClerk receivingClerk = (ReceivingClerk) optReceivingClerk.get();
        optionalDiscrepancy.setReceivingClerk(receivingClerk);

        optionalDiscrepancy.setPurchaseOrder(discrepancy.getPurchaseOrder());
        optionalDiscrepancy.setIsRemedied(discrepancy.getIsRemedied());
        optionalDiscrepancy.setDiscrepancyDate(discrepancy.getDiscrepancyDate());
        optionalDiscrepancy.setDiscrepancyIssues(discrepancy.getDiscrepancyIssues());
        optionalDiscrepancy.setVendorCorrespondence(discrepancy.getVendorCorrespondence());

        discrepancyRepository.save(optionalDiscrepancy);
        return "redirect:/discrepancies";
    }

    //    @GetMapping("edit/{discrepancyId}")
//    public String displayEditDiscrepancy(Model model, @PathVariable int discrepancyId) {
//        Discrepancy discrepancyToEdit = discrepancyRepository.findById(discrepancyId).get();
//        model.addAttribute("discrepancy", discrepancyToEdit);
//        model.addAttribute("suppliers", supplierRepository.findAll());
//        model.addAttribute("receivingClerks", receivingClerkRepository.findAll());
//
//        return "discrepancies/edit";
//    }
//
//    @PostMapping("edit/{discrepancyId}")
//    public String processEditDiscrepancyForm(@PathVariable int discrepancyId, @ModelAttribute Discrepancy discrepancy, int supplierId, int receivingClerkId) {
//        Discrepancy discrepancyToEdit = discrepancyRepository.findById(discrepancyId).get();
//        discrepancyToEdit.setPurchaseOrder(discrepancy.getPurchaseOrder());
//        discrepancyToEdit.setIsRemedied(discrepancy.getIsRemedied());
//        discrepancyToEdit.setDiscrepancyDate(discrepancy.getDiscrepancyDate());
//        discrepancyToEdit.setDiscrepancyIssues(discrepancy.getDiscrepancyIssues());
//        discrepancyToEdit.setVendorCorrespondence(discrepancy.getVendorCorrespondence());
//        Optional optSupplier = supplierRepository.findById(supplierId);
//        Supplier supplier = (Supplier) optSupplier.get();
//        discrepancyToEdit.setSupplier(supplier);
//
//        Optional optReceivingClerk = receivingClerkRepository.findById(receivingClerkId);
//        ReceivingClerk receivingClerk = (ReceivingClerk) optReceivingClerk.get();
//        discrepancyToEdit.setReceivingClerk(receivingClerk);
//
//        discrepancyRepository.save(discrepancyToEdit);
//        return "redirect:/discrepancies";
//
//    }



}
