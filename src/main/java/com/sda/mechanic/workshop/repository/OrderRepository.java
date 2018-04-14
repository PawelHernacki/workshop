package com.sda.mechanic.workshop.repository;

import com.sda.mechanic.workshop.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ServiceOrder, Long> {
}
