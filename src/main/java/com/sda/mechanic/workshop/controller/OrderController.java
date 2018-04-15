package com.sda.mechanic.workshop.controller;

import com.sda.mechanic.workshop.model.Car;
import com.sda.mechanic.workshop.model.ServiceOrder;
import com.sda.mechanic.workshop.service.CarService;
import com.sda.mechanic.workshop.service.ICarService;
import com.sda.mechanic.workshop.service.IOrderService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(path = "/order/")
public class OrderController {

    @Autowired
    private ICarService carService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("orderForm") ServiceOrder order, Model model) {
//        LoggerFactory.getLogger(getClass().getName()).info("Order: " + order);

        orderService.addOrder(order);

        return "redirect:/car/";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addOrder(@RequestParam("carid") Long carId, Model model) {
        ServiceOrder serviceOrder = new ServiceOrder();
        Optional<Car> optionalCar = carService.getCarWithId(carId);
        if (optionalCar.isPresent()) {
            serviceOrder.setCar(optionalCar.get());
        } else {
            return "redirect:/error/denied";
        }

        model.addAttribute("orderForm", serviceOrder);

        return "addorder";
    }
}
