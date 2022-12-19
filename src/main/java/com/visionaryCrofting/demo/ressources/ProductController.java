package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.endpoint}/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/id/{id}")
    public Optional<Product> getByID(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/count")
    public int count() {
        return productService.count();
    }

    @PostMapping("/")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/id/{aLong}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/ref/{ref}")
    public Product findByRef(@PathVariable("ref") String ref) {
        return productService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return productService.deleteByRef(ref);
    }

    @PostMapping("/inc/ref/{ref}/qte/{qte}")
    public Product increaseQte(@PathVariable String ref,@PathVariable int qte){
        return productService.increaseQte(ref,qte);
    }
    @PostMapping("/dec/ref/{ref}/qte/{qte}")
    public Product decreaseQte(@PathVariable String ref,@PathVariable int qte){
        return productService.decreaseQte(ref,qte);
    }
}
