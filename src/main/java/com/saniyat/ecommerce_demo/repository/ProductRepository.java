package com.saniyat.ecommerce_demo.repository;

import com.saniyat.ecommerce_demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}