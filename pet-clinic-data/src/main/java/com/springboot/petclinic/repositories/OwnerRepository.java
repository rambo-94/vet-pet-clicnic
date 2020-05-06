package com.springboot.petclinic.repositories;

import com.springboot.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    public Owner findByLastName(String lastName);
}
