package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.entity.Stock;
import com.visionaryCrofting.demo.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired
    ProductService productService;

    @Test
    public void addProductTestIfAcceptNull(){
        Product product=new Product("p5",null, null, null, 0);
        Product res=productService.save(product);
        Assertions.assertSame(product,res);
    }

//    @Test
//    public void addProductTestIfQteSupAZero(){
//        Stock stock=new Stock();
//        stock.setId(1L);
//        Product product=new Product("p88","clavier", "Cat---(", "fcgvhbjn", 0,stock);
//        Product res=productService.save(product);
//        Assertions.assertSame(product,res);
//    }

    @Test
    public void addProductTestIfNameIsMatchedWithPath(){
        Product product=new Product("p7","(-bb", "Cat", "fcgvhbjn", 4);
        Product res=productService.save(product);
        Assertions.assertSame(product,res);
    }

    @Test
    public void addProductTestIfDescIsMatchedWithPath(){
        Product product=new Product("p11","clavier", "sdftghjk", "fcgvhbjn", 2);
        Product res=productService.save(product);
        Assertions.assertSame(product,res);
    }

//    @Test
//    public void addProduct(){
//        Product product=new Product("91","Null 5bb", "Cat", "fcgvhbjn", 4);
//        Product res=productService.save(product);
//        Assertions.assertSame(product,res);
//    }


}
