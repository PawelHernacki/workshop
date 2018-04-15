package com.sda.mechanic.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/order/")
public class OrderController {

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addOrder() {
        return "redirect:/car/";
    }
}
