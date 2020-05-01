package com.springboot.petclinic.service.map;
import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.model.Pet;
import com.springboot.petclinic.service.OwnerService;
import com.springboot.petclinic.service.PetService;
import com.springboot.petclinic.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService{

    private PetTypeService petTypeService;
    private PetService petService;
    @Autowired
    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object == null){

            if(object.getPets()!= null){

                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() != null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));

                        }
                    } else {

                        throw new NullPointerException("PetType is required");
                    }
                  if(pet.getId()==null){

                      Pet savedPet=petService.save(pet);
                      pet.setId(savedPet.getId());
                  }
                });
            }
            return  super.save(object);

        }else{
            return null;
        }

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
