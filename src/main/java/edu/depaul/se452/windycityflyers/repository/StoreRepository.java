package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
