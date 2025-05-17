package com.gwozdz1uu.store.repositories;

import com.gwozdz1uu.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
