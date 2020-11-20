package edu.depaul.se452.windycityflyers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_img")
@AllArgsConstructor
@NoArgsConstructor
public class ProductImg {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "product_id")
    private Product prod;
    @Column(name = "img_path")
    private String imgPath;
    @Column(name = "img_desc")
    private String desc;

}
