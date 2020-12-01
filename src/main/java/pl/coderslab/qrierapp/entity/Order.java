package pl.coderslab.qrierapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
