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
import pl.coderslab.qrierapp.entity.Courier;
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
    private final Logger logger = LoggerFactory.getLogger(DispatcherController.class);

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
        return "dispatcher/dashboard";
    }

    @PostMapping("assignCourier")
    public String assignCourier(AssignCourierToOrder command) {
        orderService.assignCourier(command.getOrderId(), command.getCourierId());
        return "redirect:";
    }

}
