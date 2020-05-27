package com.springboot.petclinic.springdatajpa;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.repositories.OwnerRepository;
import com.springboot.petclinic.repositories.PetRepository;
import com.springboot.petclinic.repositories.PetTypeRepository;
import com.springboot.petclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastName(String lastName) {
        return ownerRepository.findAllByLastName(lastName);
    }

    @Override
    public Owner findById(Long id) {

        Optional<Owner> optionalOwner= ownerRepository.findById(id);
        if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }
        return null;

    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public List<Owner> findAll() {

        List<Owner> owners=new ArrayList<>();
        ownerRepository.findAll().forEach(owners:: add);
        return owners;
    }

    @Override
    public void delete(Owner object) {

        ownerRepository.delete(object);
    }

    @Override
    public void deleteByID(Long id) {

        ownerRepository.deleteById(id);
    }
}
