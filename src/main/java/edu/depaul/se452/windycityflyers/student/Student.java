package edu.depaul.se452.windycityflyers.student;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Date;

@Data
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "stu_id")
    private String studentId;

    @Column(name = "nm")
    private String name;

    @Email(message = "not valid email address format")
    private String email;

    private Date admittedDate;
}