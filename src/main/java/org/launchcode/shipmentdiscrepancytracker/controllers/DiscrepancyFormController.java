package org.launchcode.shipmentdiscrepancytracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiscrepancyFormController {
    @GetMapping()
    @ResponseBody
    public String form() {
        return "Hello, World!";
    }
}
