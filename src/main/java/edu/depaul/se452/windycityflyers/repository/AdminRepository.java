package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {

    @Query(value ="SELECT u FROM Admin u WHERE u.user_name = ?1" )
    Admin findByUsername(String username);
}
