package com.springboot.petclinic.springdatajpa;

import com.springboot.petclinic.model.Visit;
import com.springboot.petclinic.repositories.VisitRepository;
import com.springboot.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService  implements VisitService {

     private VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long id) {
        Optional<Visit> optionalOwner= visitRepository.findById(id);
        if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }
        return null;
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public List<Visit> findAll() {

        List<Visit> visits =new ArrayList<>();
        visitRepository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public void delete(Visit object) {
          visitRepository.save(object);
    }

    @Override
    public void deleteByID(Long id) {
            visitRepository.deleteById(id);
    }
}
