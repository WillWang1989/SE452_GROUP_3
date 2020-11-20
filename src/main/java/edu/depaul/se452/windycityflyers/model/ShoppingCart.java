package edu.depaul.se452.windycityflyers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "cart")
    private List<CartProducts> products;
    private BigDecimal totalCost;

    public int getTotalProducts(){
        if(products==null||products.size()==0) return  0;
        return products.stream().map(a->a.getCount()).reduce(0,Integer::sum);
    }
    public BigDecimal calcTotalCost(){
        if(products==null||products.size()==0) return BigDecimal.ZERO;
        this.totalCost =  products.stream().
                map(a->a.getProduct().getPrice().multiply(BigDecimal.valueOf(a.getCount())))
                .reduce(BigDecimal.ZERO,(a,b)->a.add(b));
        return  this.totalCost;
    }
}
