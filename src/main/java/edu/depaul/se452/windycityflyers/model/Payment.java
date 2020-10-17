package edu.depaul.se452.windycityflyers.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private long id;
    private String payment_type;
    private float amount;
    private int card_num;
    private Date payment_date;
    private String cust_name;
    private long cust_id;
}
