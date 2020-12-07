package pl.coderslab.qrierapp.dto;

import lombok.Data;

@Data
public class AssignCourierToOrder {

    private Long courierId;
    private Long orderId;

}
