package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.entity.Stock;
import com.visionaryCrofting.demo.service.StockService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("visionaryCrofting/Stock")
public class StockRessource {
    @Autowired
    private StockService stockService;

    @PostMapping("/create")
    public Stock saveStock(@RequestBody Stock stock){
        return stockService.save(stock);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
       stockService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Stock update(@RequestBody Stock stock) {
        return stockService.updateStock(stock);
    }

   
}
