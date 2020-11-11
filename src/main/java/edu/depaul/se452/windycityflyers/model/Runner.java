package edu.depaul.se452.windycityflyers.model;


import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Runner {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "runner_name")
    private String name;
    @Column(name = "runner_phone")
    private String phone;
    private String password;

}
