package pl.coderslab.qrierapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.qrierapp.dto.AssignCourierToOrder;
import pl.coderslab.qrierapp.entity.Order;
import pl.coderslab.qrierapp.entity.OrderStatus;
import pl.coderslab.qrierapp.service.AddressService;
import pl.coderslab.qrierapp.service.ClientService;
import pl.coderslab.qrierapp.service.CourierService;
import pl.coderslab.qrierapp.service.OrderService;

@Controller
@RequestMapping("/dispatcher")
public class DispatcherController {

    private final CourierService courierService;
    private final AddressService addressService;
    private final ClientService clientService;
    private final OrderService orderService;

    @Autowired
    public DispatcherController(CourierService courierService,
                                AddressService addressService,
                                ClientService clientService,
                                OrderService orderService) {
        this.courierService = courierService;
        this.addressService = addressService;
        this.clientService = clientService;
        this.orderService = orderService;
    }

    @GetMapping("")
    public String listActiveOrders(Model model) {
        model.addAttribute("activeOrders", orderService.getActiveOrders());
        model.addAttribute("activeCouriers", courierService.getActiveCouriers());
        return "dispatcher/activeOrders";
    }

    @PostMapping("/assignCourier")
    public String assignCourier(AssignCourierToOrder command) {
        orderService.assignCourier(command.getOrderId(), command.getCourierId());
        return "redirect:";
    }

    @GetMapping("/finishedOrders")
    public String listFinishedOrders(Model model) {
        model.addAttribute("finishedOrders", orderService.getOrdersByStatus(OrderStatus.FINISHED));
        return "dispatcher/finishedOrders";
    }

    @GetMapping("/addOrder")
    public String addOrder(Model model) {
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("newOrder", new Order());
        return "dispatcher/addOrder";
    }

}