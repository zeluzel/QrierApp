package pl.coderslab.qrierapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public DispatcherController(CourierService courierService, AddressService addressService, ClientService clientService, OrderService orderService) {
        this.courierService = courierService;
        this.addressService = addressService;
        this.clientService = clientService;
        this.orderService = orderService;
    }

    @GetMapping("")
    public String listActiveOrders(Model model) {
        model.addAttribute("activeOrders", orderService.getActiveOrders());
        model.addAttribute("activeCouriers", courierService.getActiveCouriers());
        return "dispatcher/dashboard";
    }

//    @ModelAttribute("activeOrders")
//    public List<Order> loadActiveOrders() {
//        return orderService.getActiveOrders();
//    }
}
