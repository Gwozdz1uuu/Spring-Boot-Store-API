package com.gwozdz1uu.store.repositories;

import com.gwozdz1uu.store.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}