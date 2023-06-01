package com.jr.store.controller;

import com.jr.store.entity.Product;
import com.jr.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;


@Controller
@RequestMapping("/store")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String test() {
        return "index";
    }

    @GetMapping("/listAll")
    public String listAllProd() {
        return "dashboard";
    }

    @GetMapping("/listAllProd")
    public String lAP(Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "dashboard";
    }

    @PostMapping("/saveNewProduct")
    public String saveNewProduct(Model model,
                                 @RequestParam("name") String name,
                                 @RequestParam("category") String category,
                                 @RequestParam("file") MultipartFile file) {
        Product product = new Product();
        model.addAttribute("product", product);
        product.setName(name);
        product.setCategory(category);
        try {
            String imgString = Base64.getEncoder().encodeToString(file.getBytes());
            product.setProductImage(imgString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.saveProduct(product);

        return "redirect:/store/listAllProd";
    }

    // C = Create
    @PostMapping("/addProduct")
    public String saveProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "success";
    }

    // R = Read
    @GetMapping("/listProduct")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    // R = Read by id
    @GetMapping("/byId/{id}")
    public Product byId(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // D = Delete
    @PostMapping("/remove/{id}")
    public String removeProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return "product " + id + " deleted successfully";
    }

    // U = Update
    @PutMapping("/edit/{id}")
    public String editProductInfo(@PathVariable int id, @RequestBody Product product) {
        Product existingProduct = productService.getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());

        productService.saveProduct(existingProduct);
        return "Product " + id + "updated successfully!";
    }
}
