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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "order_status")
    private int orderStatus;
    //TODO: add relation to payment table
    @Column(name = "payment_id")
    private int paymentId;
    //TODO: add relation to delivery table
    @Column(name = "delivery_id")
    private int deliveryId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @ToString.Exclude
    @OneToMany(mappedBy = "order")
    private List<OrderProducts> products;
    // private BigDecimal shippingFee;
}
