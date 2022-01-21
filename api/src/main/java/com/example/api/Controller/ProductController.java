package com.example.api.Controller;



import com.example.api.DTO.Products;
import com.example.api.Interface.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {
    private final ProductRepository productRepository;
       @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products")
    public List<Products> getProducts(){
        return productRepository.findAll();
    }
    @PutMapping("/api/editproduct/{id}")
    public Products EditProduct(@PathVariable("id") ObjectId id, @RequestBody Products product) {
        product.set_id(id);
       productRepository.save(product);
        return product;
    }
    @DeleteMapping("/api/deleteproduct/{id}")
    public void deleteContact(@PathVariable ObjectId id) {
        productRepository.delete(productRepository.findBy_id(id));
    }
    @GetMapping("/api/products/{id}")
    public Products getContactById(@PathVariable("id") ObjectId id) {
        return productRepository.findBy_id(id);
    }


}
