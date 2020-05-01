package com.springboot.petclinic.service.map;
import com.springboot.petclinic.model.Specialty;
import com.springboot.petclinic.model.Vet;

import com.springboot.petclinic.service.SpecialtyService;
import com.springboot.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private SpecialtyService specialtyService;
    @Autowired
    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size()>0){
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){

                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());


                }


            });


        }

        return  super.save(object);
    }

    @Override
    public List<Vet> findAll() {
        return (List<Vet>) super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {

        super.delete(object);

    }

}
