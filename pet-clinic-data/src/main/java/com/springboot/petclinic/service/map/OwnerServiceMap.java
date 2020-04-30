package com.springboot.petclinic.service.map;
import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService{


    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        return  super.save(object.getId(),object);
    }

    @Override
    public List<Owner> findAll() {
        return (List<Owner>) super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
         super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {

        super.delete(object);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
