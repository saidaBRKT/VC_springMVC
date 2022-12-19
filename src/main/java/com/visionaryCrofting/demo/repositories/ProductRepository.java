package com.visionaryCrofting.demo.repositories;

import com.visionaryCrofting.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByRef(String ref);
    int deleteByRef(String ref);
}
