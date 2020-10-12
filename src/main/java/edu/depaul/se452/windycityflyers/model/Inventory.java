package edu.depaul.se452.windycityflyers.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long quantity;
    private String brand;
    private String availability;

}