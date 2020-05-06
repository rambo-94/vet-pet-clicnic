package com.springboot.petclinic.springdatajpa;


import com.springboot.petclinic.model.Vet;
import com.springboot.petclinic.repositories.OwnerRepository;
import com.springboot.petclinic.repositories.PetTypeRepository;
import com.springboot.petclinic.repositories.VetRepository;
import com.springboot.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private OwnerRepository ownerRepository;
    private VetRepository vetRepository;
    private PetTypeRepository petTypeRepository;

    public VetSDJpaService(OwnerRepository ownerRepository, VetRepository vetRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.vetRepository = vetRepository;
        this.petTypeRepository = petTypeRepository;
    }
    @Override
    public Vet findById(Long id) {
        Optional<Vet> optionalVet= vetRepository.findById(id);
        if(optionalVet.isPresent()){
            return optionalVet.get();
        }
        return null;
    }

    @Override
    public Vet save(Vet object) {
            return vetRepository.save(object);
    }

    @Override
    public List<Vet> findAll(){
        List<Vet> vets=new ArrayList<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void delete(Vet object) {

        vetRepository.delete(object);

    }

    @Override
    public void deleteByID(Long id) {

        vetRepository.deleteById(id);

    }
}

