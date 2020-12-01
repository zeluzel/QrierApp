package pl.coderslab.qrierapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Client(String companyName, Address address) {
        this.companyName = companyName;
        this.address = address;
    }
}
