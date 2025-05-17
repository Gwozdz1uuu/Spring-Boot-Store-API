package com.gwozdz1uu.store.repositories;

import com.gwozdz1uu.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}