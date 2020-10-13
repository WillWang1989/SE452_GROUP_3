package edu.depaul.se452.windycityflyers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reviews")
public class ShoppingCart {
    private static final long serialVersionUID = 4734628184778231571L;
    @MongoId
    private String id;
    private long userId;
    // TODO: orderid in OrderProducts need be changed to shoppingcartid
    private List<OrderProducts> items;
    private BigDecimal totalCost;
}
