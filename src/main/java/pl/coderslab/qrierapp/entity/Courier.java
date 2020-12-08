package pl.coderslab.qrierapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "couriers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courier implements EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String alias;
    private String phone;
    private Boolean active;

    @OneToMany(mappedBy = "courier")
    private List<Order> orders;

    public Courier(String firstName, String lastName, String alias) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", alias='" + alias + '\'' +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                '}';
    }

}
