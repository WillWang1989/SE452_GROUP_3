package edu.depaul.se452.windycityflyers.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;
    private String product_brand;
    private String product_name;
    private String product_description;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department dept;
}