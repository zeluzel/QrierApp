package pl.coderslab.qrierapp.entity;

import lombok.Data;

import javax.persistence.*;

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
    private String notes;

    @ManyToOne
    private Client client;
}
