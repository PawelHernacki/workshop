package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.model.Car;

import java.util.Optional;

public interface ICarService {
    void addNewCar(Car car);

    Optional<Car> getCarWithId(Long carId);

    void remove(Car car);
}
