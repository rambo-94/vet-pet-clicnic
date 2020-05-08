package com.springboot.petclinic.service.map;

import com.springboot.petclinic.model.PetType;
import com.springboot.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile({"default","map"})
public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService {
    @Override
    public PetType findById(Long id) {

        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {


        return super.save(object);
    }

    @Override
    public List<PetType> findAll() {


        return super.findAll();
    }

    @Override
    public void delete(PetType object) {

         super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);

    }
}
