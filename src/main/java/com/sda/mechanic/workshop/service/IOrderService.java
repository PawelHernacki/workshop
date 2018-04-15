package com.sda.mechanic.workshop.service;

import com.sda.mechanic.workshop.model.ServiceOrder;

import java.util.List;

public interface IOrderService {
    void addOrder(ServiceOrder order);

    List<ServiceOrder> getAll();
}
