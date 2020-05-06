package com.springboot.petclinic.springdatajpa;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.model.Pet;
import com.springboot.petclinic.repositories.OwnerRepository;
import com.springboot.petclinic.repositories.PetRepository;
import com.springboot.petclinic.repositories.PetTypeRepository;
import com.springboot.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    public PetSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Pet findById(Long id) {

        Optional<Pet> optionalOwner= petRepository.findById(id);
        if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }
        return null;

    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public List<Pet> findAll() {
        List<Pet> pets=new ArrayList<>();
        petRepository.findAll().forEach(pets:: add);
        return pets;
    }

    @Override
    public void delete(Pet object) {
       petRepository.delete(object);
    }

    @Override
    public void deleteByID(Long id) {


        petRepository.deleteById(id);
    }
}
