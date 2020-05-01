package com.springboot.petclinic.service.map;
import com.springboot.petclinic.model.Pet;
import com.springboot.petclinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {


    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {

        return  super.save(object);
    }

    @Override
    public List<Pet> findAll() {
        return (List<Pet>) super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {

        super.delete(object);

    }

}
