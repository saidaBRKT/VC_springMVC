package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.entity.Stock;
import com.visionaryCrofting.demo.repositories.ProductRepository;
import com.visionaryCrofting.demo.repositories.StockRepository;
import com.visionaryCrofting.demo.service.ProductService;
import com.visionaryCrofting.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StockRepository stockRepository;
    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public int count() {
        return productRepository.findAll().size();
    }

//    @Override
//    public Product save(Product product) {
//        if (product.getCategory()== null || product.getNom()==null ||
//            product.getDescreption()==null) {
//            throw new IllegalStateException("Toutes les données sont obligatoires");
//        }
//        else {
//            Pattern pattNom = Pattern.compile("^[A-Za-z\\s]{5,20}$");
//            Matcher matcherNom = pattNom.matcher(product.getNom());
//            if(product.getQuantity()<=0){
//                throw new IllegalStateException("La quantité doit etre superieur a 0");
//            }
//            else if(!matcherNom.matches()) {
//                throw new IllegalStateException("Le nom est non valide");
//            }
//            else{
//                return productRepository.save(product);
//            }
//        }
//
//    }

    @Override
    public Product save(Product product) {
        Product byRef = this.findByRef(product.getRef());
        if (byRef != null) {
            return null;
        }else {
            if(product.getStock()!=null){
                Optional<Stock> s = stockRepository.findById(product.getStock().getId());
                if(s.isPresent()){
                    product.setStock(s.get());
                    return productRepository.save(product);
                }else{
                    throw new IllegalStateException("Le stock qui a un id = "+product.getStock().getId()+" n'existe pas ");
                }
            }else {
                throw new IllegalStateException("Le stock est obligatoire");
            }
        }

    }

    @Override
    public Product update(Product t) {
        Product byRef = this.findByRef(t.getRef());
        if (byRef == null){
            throw new IllegalStateException("product not found");
        }else {
            byRef.setRef(t.getRef());
            byRef.setQuantity(t.getQuantity());
            byRef.setDescreption(t.getDescreption());
            byRef.setNom(t.getNom());
            byRef.setCategory(t.getCategory());
            Optional<Stock> stock = Optional.of(stockRepository.getById(t.getStock().getId()));
            if(stock.isPresent()) {
                byRef.setStock(stock.get());
            }else{
                throw new IllegalStateException("stock not found");
            }
            return productRepository.save(byRef);
        }
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findByRef(String ref) {
        return productRepository.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return productRepository.deleteByRef(ref);
    }

    @Override
    public Product increaseQte(String ref, int qte) {
        Product product=productRepository.findByRef(ref);
        if(product==null){
            throw new IllegalStateException("Le produit n'existe pas dans le stock");
        }else {
            product.setQuantity(product.getQuantity()+qte);
            productRepository.save(product);
            return product;
            }
    }

    @Override
    public Product decreaseQte(String ref, int qte) {
        Product  product=productRepository.findByRef(ref);
        if(qte>product.getQuantity())
        {
            throw new IllegalStateException("La quantité requise est supérieure à la quantité disponible");
        }else {
            product.setQuantity(product.getQuantity()-qte);
            return product;
        }
    }
}
