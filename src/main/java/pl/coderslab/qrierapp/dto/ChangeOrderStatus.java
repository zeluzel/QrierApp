package pl.coderslab.qrierapp.dto;

import lombok.Data;
import pl.coderslab.qrierapp.entity.OrderStatus;

@Data
public class ChangeOrderStatus {

    private Long orderId;
    private OrderStatus orderStatus;

}
