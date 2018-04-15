package com.sda.mechanic.workshop.controller;

import com.sda.mechanic.workshop.model.Car;
import com.sda.mechanic.workshop.model.User;
import com.sda.mechanic.workshop.service.ICarService;
import com.sda.mechanic.workshop.service.IUserService;
import com.sda.mechanic.workshop.service.SecurityService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping(path = "/car/")
public class CarController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICarService carService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String cars(Model model) {
        Optional<User> userOptional = securityService.getLoggedInUser();

        // jesli znajdziemy uzytkownika w bazie
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // dodajemy samochody do attribute, zeby za chwile wyswietlic je w cars.jsp
            model.addAttribute("user_cars", user.getCarList());
            return "cars";
        }

        // redirect - skoro nie znalezlismy uzytkownika, to znaczy ze nie jest zalogowany
        return "redirect:/user/login";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addCar(Model model) {
        model.addAttribute("carForm", new Car());
        return "addcar";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String submitCar(@ModelAttribute("carForm") Car car, Model model) {
        Optional<User> userOptional = securityService.getLoggedInUser();

        if (userOptional.isPresent()) {
            car.setOwner(userOptional.get());
            carService.addNewCar(car);

            return "redirect:/car/";
        }

        return "redirect:/user/login";
    }

}
