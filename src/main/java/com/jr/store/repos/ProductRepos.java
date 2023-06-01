package com.jr.store.repos;

import com.jr.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepos extends JpaRepository<Product, Integer> {
}
