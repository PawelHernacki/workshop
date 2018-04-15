package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.model.Car;
import com.sda.mechanic.workshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService implements ICarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void addNewCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Optional<Car> getCarWithId(Long carId) {
        return carRepository.findById(carId);
    }

    @Override
    public void remove(Car car) {
        carRepository.delete(car);
    }
}
