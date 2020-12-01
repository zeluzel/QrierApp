package pl.coderslab.qrierapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order implements EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Address sender;

    @ManyToOne
    private Address receiver;

    @ManyToOne
    private Client payer;

    private Double price;

//    @PrePersist
//    private LocalDateTime created;

    @ManyToOne
    private Courier courier;

    private OrderStatus status;
    private String notes;

}
