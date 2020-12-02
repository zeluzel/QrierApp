package pl.coderslab.qrierapp.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.qrierapp.entity.*;
import pl.coderslab.qrierapp.service.AddressService;
import pl.coderslab.qrierapp.service.ClientService;
import pl.coderslab.qrierapp.service.CourierService;
import pl.coderslab.qrierapp.service.OrderService;

import java.util.List;
import java.util.Random;

@Component
public class OrderFixture {

    private final OrderService orderService;
    private final CourierService courierService;
    private final AddressService addressService;
    private final ClientService clientService;

    private List<Order> orders = List.of(
            new Order(15d, OrderStatus.ORDERED, "śpieszy się"),
            new Order(15d, OrderStatus.ORDERED, "nie śpieszy się"),
            new Order(15d, OrderStatus.ORDERED, "proszę nie trzaskać drzwiami")
    );

    @Autowired
    public OrderFixture(OrderService orderService,
                        CourierService courierService,
                        AddressService addressService,
                        ClientService clientService) {
        this.orderService = orderService;
        this.courierService = courierService;
        this.addressService = addressService;
        this.clientService = clientService;
    }

    public void loadIntoDB() {
        Random random = new Random();
        List<Address> addresses = addressService.findAll();
        List<Courier> couriers = courierService.findAll();
        List<Client> clients = clientService.findAll();

        for (Order order : orders) {
            order.setCourier(couriers.get(random.nextInt(couriers.size())));
            order.setPayer(clients.get(random.nextInt(clients.size())));
            order.setSender(addresses.get(random.nextInt(addresses.size())));
//            while (order.getSender().equals(order.getReceiver())) {
                order.setReceiver(addresses.get(random.nextInt(addresses.size())));
//            }
            orderService.save(order);
        }
    }


}
