package pl.coderslab.qrierapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.qrierapp.dto.ChangeOrderStatus;
import pl.coderslab.qrierapp.entity.Courier;
import pl.coderslab.qrierapp.entity.Order;
import pl.coderslab.qrierapp.service.AddressService;
import pl.coderslab.qrierapp.service.ClientService;
import pl.coderslab.qrierapp.service.CourierService;
import pl.coderslab.qrierapp.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/courier")
public class CourierController {

    private final CourierService courierService;
    private final AddressService addressService;
    private final ClientService clientService;
    private final OrderService orderService;
    private Courier courier;

    @Autowired
    public CourierController(CourierService courierService, AddressService addressService, ClientService clientService, OrderService orderService) {
        this.courierService = courierService;
        this.addressService = addressService;
        this.clientService = clientService;
        this.orderService = orderService;
    }

    @GetMapping
    public String listActiveOrders(Model model) {
//        TODO pobieranie kuriera z sesji
        courier = courierService.findById(1L);
        model.addAttribute("courier", courier);
        model.addAttribute("activeOrders", orderService.getActiveOrdersForCourier(courier));
        return "courier/activeOrders";
    }

    @PostMapping("/changeOrderStatus")
    public String changeOrderStatus(ChangeOrderStatus command) {
        orderService.changeOrderStatus(command.getOrderId(), command.getOrderStatus());
        return "redirect:";
    }

    @GetMapping("/finishedOrders")
    public String listFinishedOrders(Model model) {
        courier = courierService.findById(1L);
        List<Order> finishedOrders = orderService.getFinishedOrdersForCourier(courier);
        Double earned = 0d;
        for (Order order : finishedOrders) {
            earned += order.getPrice();
        }
        model.addAttribute("courier", courier);
        model.addAttribute("finishedOrders", finishedOrders);
        model.addAttribute("earned", earned);
        return "courier/finishedOrders";
    }

}
