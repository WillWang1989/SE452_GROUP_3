package edu.depaul.se452.windycityflyers.model;

//import Model.Products.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime orderDate;
    private int orderStatus;
    //TODO: add relation to payment table
    private int paymentId;
    //TODO: add relation to delevery table
    private int deliverId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    private BigDecimal totalCost;

    @ToString.Exclude
    @OneToMany
    @JoinTable(
            name = "order_products",
            joinColumns={ @JoinColumn(name="order_id", referencedColumnName="id")  }
    )
    private List<Product> items;
    // private BigDecimal shippingFee;
}
