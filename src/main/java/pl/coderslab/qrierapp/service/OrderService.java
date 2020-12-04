package pl.coderslab.qrierapp.service;

import pl.coderslab.qrierapp.entity.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    Order findById(Long id);

    List<Order> findAll();

    List<Order> getActiveOrders();

}
