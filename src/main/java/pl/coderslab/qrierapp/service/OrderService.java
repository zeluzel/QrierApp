package pl.coderslab.qrierapp.service;

import pl.coderslab.qrierapp.entity.Courier;
import pl.coderslab.qrierapp.entity.Order;
import pl.coderslab.qrierapp.entity.OrderStatus;

import java.util.List;

public interface OrderService {

    void save(Order order);

    Order findById(Long id);

    List<Order> findAll();

    List<Order> getActiveOrders();

    void assignCourier(Long orderId, Long courierId);

    List<Order> getActiveOrdersForCourier(Courier courier);

    void changeOrderStatus(Long orderId, OrderStatus orderStatus);
}
