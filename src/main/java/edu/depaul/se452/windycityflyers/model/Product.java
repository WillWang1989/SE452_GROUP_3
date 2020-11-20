package edu.depaul.se452.windycityflyers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department dept;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "store_id",nullable = false)
    private Store store;

    @OneToMany(mappedBy = "prod")
    private List<ProductImg> imgList;
    public String getDefaultImage(){
        if(this.imgList!=null && this.imgList.size()>0){
            return imgList.get(0).getImgPath();
        }else {
            return "/uploaded/unavailable.jpg";
        }
    }
}