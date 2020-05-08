package com.springboot.petclinic.service.map;

import com.springboot.petclinic.model.Specialty;
import com.springboot.petclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile({"default","map"})
public class SpecialtyMapService  extends AbstractMapService<Specialty,Long> implements SpecialtyService {
    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {

        return super.save(object);
    }

    @Override
    public List<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Specialty object) {

        super.delete(object);

    }
}
