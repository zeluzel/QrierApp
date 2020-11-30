package pl.coderslab.qrierapp.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

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

    @OneToMany(mappedBy = "client")
    private List<Address> address;

    @OneToMany(mappedBy = "client")
    private List<Order> ordersList;
}
