package pl.coderslab.qrierapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
public class Client implements EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String firstName;
    private String lastName;
    private String alias;
    private String phone;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "payer")
    private List<Order> ordersList;
}
