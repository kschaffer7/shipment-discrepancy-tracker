package org.launchcode.shipmentdiscrepancytracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// This page renders the home page / root path.
// The GET handler method will try to find the index template
@Controller
public class HomeController {
    @GetMapping
    public String index() {
        return "index";
    }
}
