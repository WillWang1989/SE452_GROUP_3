package edu.depaul.se452.windycityflyers.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.DecimalFormat;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;
    private String product_brand;
    private String product_name;
    private String product_description;
    private String dept;
    private Float price;


}