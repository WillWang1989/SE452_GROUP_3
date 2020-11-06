package edu.depaul.se452.windycityflyers.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
    @OneToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department dept;
    @ManyToOne
    @JoinColumn(name = "store_id",nullable = false)
    private Store store;

    @ToString.Exclude
    @OneToMany(mappedBy = "prod")
    private List<ProductImg> imgList;
}