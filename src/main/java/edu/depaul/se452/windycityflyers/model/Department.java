package edu.depaul.se452.windycityflyers.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "store_id",nullable = false)
    private Store store;
}
