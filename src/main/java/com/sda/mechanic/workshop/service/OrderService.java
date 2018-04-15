package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.model.ServiceOrder;
import com.sda.mechanic.workshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void addOrder(ServiceOrder order) {
        order.setDateSubmitted(LocalDate.now());

        orderRepository.save(order);
    }

    @Override
    public List<ServiceOrder> getAll() {
        return orderRepository.findAll();
    }
}
