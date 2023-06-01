package com.jr.store.service.impl;

import com.jr.store.entity.Product;
import com.jr.store.repos.ProductRepos;
import com.jr.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepos productRepos;
    @Override
    public List<Product> getAllProducts() {
        return productRepos.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepos.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepos.findById(id).get();
    }

    @Override
    public void deleteProductById(int id) {
        productRepos.deleteById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepos.save(product);
    }
}
