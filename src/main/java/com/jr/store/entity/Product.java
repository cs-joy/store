package com.jr.store.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB",length = 1000)
    private String ProductImage;

    public Product() {
    }

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Product(String name, String category, String productImage) {
        this.name = name;
        this.category = category;
        ProductImage = productImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String productImage) {
        ProductImage = productImage;
    }
}
