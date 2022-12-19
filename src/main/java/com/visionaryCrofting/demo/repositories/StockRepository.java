package com.visionaryCrofting.demo.repositories;

import com.visionaryCrofting.demo.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    
}
