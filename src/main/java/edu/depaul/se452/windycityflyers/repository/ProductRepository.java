package edu.depaul.se452.windycityflyers.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.depaul.se452.windycityflyers.model.Product;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p where (p.store.id  =?1 or 0=?1) and (p.product_brand like %?2% or p.product_name like  %?2% or p.product_description like  %?2%) ")
    Page<Product> findInAllFields(Long storeId,String q, Pageable pageable);
}
