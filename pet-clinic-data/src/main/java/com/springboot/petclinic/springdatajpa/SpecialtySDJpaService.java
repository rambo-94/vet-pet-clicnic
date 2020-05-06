package com.springboot.petclinic.springdatajpa;

import com.springboot.petclinic.model.Specialty;
import com.springboot.petclinic.repositories.SpecialtyRepository;
import com.springboot.petclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

    private SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService( SpecialtyRepository specialtyRepository) {

        this.specialtyRepository = specialtyRepository;
    }
    @Override
    public Specialty findById(Long id) {
        Optional<Specialty> optionalOwner= specialtyRepository.findById(id);
        if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }
        return null;
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public List<Specialty> findAll() {
        List<Specialty> specialties=new ArrayList<>();
        specialtyRepository.findAll().forEach(specialties:: add);
        return specialties;
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        specialtyRepository.deleteById(id);
    }
}
