package com.springboot.petclinic.springdatajpa;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.model.PetType;
import com.springboot.petclinic.repositories.PetTypeRepository;
import com.springboot.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService( PetTypeRepository petTypeRepository) {

        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public PetType findById(Long id) {
        Optional<PetType> optionalOwner= petTypeRepository.findById(id);
        if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }
        return null;    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public List<PetType> findAll() {

        List<PetType> petTypes=new ArrayList<>();
        petTypeRepository.findAll().forEach(petTypes:: add);
        return petTypes;
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteByID(Long id) {


        petTypeRepository.deleteById(id);
    }
}
