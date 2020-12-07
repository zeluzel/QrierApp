package pl.coderslab.qrierapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.qrierapp.entity.Courier;
import pl.coderslab.qrierapp.entity.Order;
import pl.coderslab.qrierapp.repository.CourierRepository;
import pl.coderslab.qrierapp.repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CourierRepository courierRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CourierRepository courierRepository) {
        this.orderRepository = orderRepository;
        this.courierRepository = courierRepository;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getActiveOrders() {
        return orderRepository.findActiveOrders();
    }

    @Override
    public void assignCourier(Long orderId, Long courierId) {
        Order order = orderRepository.getOne(orderId);
        Courier courierToAssign = courierRepository.getOne(courierId);
        order.setCourier(courierToAssign);
        orderRepository.save(order);
    }

}
