package edu.depaul.se452.windycityflyers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;
    // user may not want to register
    private String password;
    @Column(name="tel_no")
    private String telNo;
    private String address1;
    private String address2;

}
