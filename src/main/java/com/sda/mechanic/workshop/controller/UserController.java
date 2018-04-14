package com.sda.mechanic.workshop.controller;

import com.sda.mechanic.workshop.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping(path = "/user/")
public class UserController {

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addUserForm(Model model) {

        return "add";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        LoggerFactory.getLogger(getClass().getName()).info("Register: ");

        model.addAttribute("userForm", new User());

        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String registerForm(@ModelAttribute("userForm") User user, Model model) {
        LoggerFactory.getLogger(getClass().getName()).info("Register: " + user);

        return "index";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginUser(Model model) {
        model.addAttribute("zmienna", "wartosc");
        return "login";
    }
}
