package com.jr.store.service;

import com.jr.store.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product getProductById(int id);
    void deleteProductById(int id);
    Product saveProduct(Product product);
}
