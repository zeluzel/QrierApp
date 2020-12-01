package pl.coderslab.qrierapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
public class Address implements EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer houseNumber;
    private Integer apartamentNumber;
    private String zipCode;
    private String city;
    private String notes;

    @OneToMany(mappedBy = "sender")
    private List<Order> ordersAsSender;

    @OneToMany(mappedBy = "receiver")
    private List<Order> ordersAsReceiver;

    @OneToOne(mappedBy = "address")
    private Client client;

}
