package com.sda.mechanic.workshop.controller;

import com.sda.mechanic.workshop.exceptions.UsernameAlreadyExistsException;
import com.sda.mechanic.workshop.model.Role;
import com.sda.mechanic.workshop.model.User;
import com.sda.mechanic.workshop.repository.RoleRepository;
import com.sda.mechanic.workshop.service.IUserService;
import com.sda.mechanic.workshop.service.SecurityService;
import com.sda.mechanic.workshop.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Controller
@RequestMapping(path = "/user/")
public class UserController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addUserForm(Model model) {

        return "add";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        LoggerFactory.getLogger(getClass().getName()).info("Register: ");

        model.addAttribute("userForm", new User());
        model.addAttribute("error", false);

        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String registerForm(@ModelAttribute("userForm") User user, Model model) {
        LoggerFactory.getLogger(getClass().getName()).info("Register: " + user);

        Optional<Role> basicRole = roleRepository.findByName("USER");
        Role role;
        if (!basicRole.isPresent()) {
            // tylko na początku, w przypadku gdy nie mamy tej roli jeszcze dodanej
            role = new Role();
            role.setName("USER");

            role = roleRepository.save(role);
        } else {
            role = basicRole.get();
        }

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        try {
            userService.registerUser(user);
        } catch (UsernameAlreadyExistsException e) {
            model.addAttribute("userForm", user);

            model.addAttribute("error", true);
            model.addAttribute("error_message", "Username already exists!");
            return "register";
        }

        securityService.autologin(user.getUsername(), user.getPassword());

        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginUser(Model model) {
        model.addAttribute("zmienna", "wartosc");

        return "login";
    }
}
