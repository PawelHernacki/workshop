package com.sda.mechanic.workshop.controller;

import com.sda.mechanic.workshop.model.ServiceOrder;
import com.sda.mechanic.workshop.model.User;
import com.sda.mechanic.workshop.model.dto.UserInfoDto;
import com.sda.mechanic.workshop.service.IOrderService;
import com.sda.mechanic.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/admin/")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping(path = "/listusers", method = RequestMethod.GET)
    public String listUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        List<UserInfoDto> userInfoDtos = userList.stream()
                .map(user -> new UserInfoDto(user.getId(), user.getUsername(), user.getRole()))
                .collect(Collectors.toList());

        model.addAttribute("user_list", userInfoDtos);

        return "listusers";
    }

    @RequestMapping(path = "/listorders", method = RequestMethod.GET)
    public String list(Model model) {
        List<ServiceOrder> orders = orderService.getAll();

        model.addAttribute("orders_list", orders);

        return "orderlist";
    }
}
