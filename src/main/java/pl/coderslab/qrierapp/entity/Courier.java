package pl.coderslab.qrierapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "couriers")
@Data
public class Courier implements EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String alias;
    private String phone;
    private Boolean active;

    @OneToMany
    private List<Order> orders;

}
