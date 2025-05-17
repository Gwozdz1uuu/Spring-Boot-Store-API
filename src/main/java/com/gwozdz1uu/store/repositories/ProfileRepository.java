package com.gwozdz1uu.store.repositories;

import com.gwozdz1uu.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}