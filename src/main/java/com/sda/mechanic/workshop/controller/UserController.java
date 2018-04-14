package com.sda.mechanic.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user/")
public class UserController {

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addUserForm(Model model) {

        return "index";
    }

}
