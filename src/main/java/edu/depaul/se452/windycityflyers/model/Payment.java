package edu.depaul.se452.windycityflyers.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    private String payment_type;
    private float amount;
    @NotEmpty
    private int card_num;
    @NotEmpty
    private Date payment_date;
    @NotEmpty
    private String cust_name;
    @NotEmpty
    private long cust_id;
}
