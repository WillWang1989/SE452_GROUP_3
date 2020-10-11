package Model.Users;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Admin {

    @Id
    @GeneratedValue
    private long id;
    private String user_name;
    private String name;

}
