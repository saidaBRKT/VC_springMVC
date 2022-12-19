package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StockService {


    Stock save(Stock stock);
    void deleteById(Long id);
    Stock updateStock(Stock stock);

    Optional<Stock> getById(Long id);
    List<Stock> getAll();
}
