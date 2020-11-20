package edu.depaul.se452.windycityflyers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_products")
public class CartProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "shoppingcart_id")
    private ShoppingCart cart;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
    private int count;
}
