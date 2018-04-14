package com.sda.mechanic.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/user/")
public class UserController {

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addUserForm(Model model) {

        return "add";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginUser(Model model){

        model.addAttribute("zmienna", "wartosc");
        return "login";
    }
}
