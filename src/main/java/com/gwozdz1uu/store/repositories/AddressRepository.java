package com.gwozdz1uu.store.repositories;

import com.gwozdz1uu.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}