package pl.coderslab.qrierapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Address sender;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Address receiver;

    @ManyToOne
    private Client payer;

    private Double price;

    private LocalDateTime createdOn;

    @ManyToOne
    private Courier courier;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    private String notes;

    public Order(Double price, OrderStatus status, String notes) {
        this.price = price;
        this.status = status;
        this.notes = notes;
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", price=" + price +
                ", createdOn=" + createdOn +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                '}';
    }
}
