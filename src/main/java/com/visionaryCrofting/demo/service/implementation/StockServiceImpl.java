package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.entity.Stock;
import com.visionaryCrofting.demo.repositories.StockRepository;
import com.visionaryCrofting.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class StockServiceImpl implements StockService {
    private Product product;
    private AppelOffreServiceImpl appelOffreServiceImpl;
    @Autowired
    StockRepository repository;

    @Override
    public Stock save(Stock stock) {
        return repository.save(stock);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }

     @Override
    public Stock updateStock(Stock stock){
        return  repository.save(stock);
    }

    @Override
    public Optional<Stock> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Stock> getAll() {
        return repository.findAll();
    }



}
