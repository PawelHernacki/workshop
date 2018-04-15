package com.sda.mechanic.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/error/")
public class ErrorController {

    @RequestMapping(path = "/denied", method = RequestMethod.GET)
    public String denied(Model model) {

        return "errordenied";
    }
}
