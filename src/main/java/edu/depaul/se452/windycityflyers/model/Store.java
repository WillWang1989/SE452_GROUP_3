package edu.depaul.se452.windycityflyers.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class Store {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    @Size(max = 30)
    private String store_name;
    @NotEmpty
    @Size(max = 150)
    private String street_address;
    @NotEmpty
    @Size(max = 50)
    private String city;
    @NotEmpty
    @Size(max = 10)
    private String state;
    @Size(min = 5,max = 5)
    private String zip;
}