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

    @OneToOne
    private Client sender;

    @OneToOne
    private Client receiver;

    private Double price;

//    @PrePersist
//    private LocalDateTime created;

    @OneToOne
    private Courier courier;

    private OrderStatus status;
    private String notes;

}
