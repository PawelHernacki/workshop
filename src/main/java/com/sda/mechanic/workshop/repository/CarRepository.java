package com.sda.mechanic.workshop.repository;

import com.sda.mechanic.workshop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
