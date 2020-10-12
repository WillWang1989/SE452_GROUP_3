package edu.depaul.se452.windycityflyers.model;


import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Runner {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String phone;

}
