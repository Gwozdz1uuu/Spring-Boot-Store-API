package com.gwozdz1uu.store.repositories;

import com.gwozdz1uu.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}