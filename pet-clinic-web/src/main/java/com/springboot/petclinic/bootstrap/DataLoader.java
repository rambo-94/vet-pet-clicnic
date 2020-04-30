package com.springboot.petclinic.bootstrap;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.model.Pet;
import com.springboot.petclinic.model.PetType;
import com.springboot.petclinic.service.OwnerService;
import com.springboot.petclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private OwnerService ownerService;
    private PetService petService;

    @Autowired
    public void DataLoader(OwnerService ownerService,PetService petService) {

        this.ownerService=ownerService;
        this.petService=petService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Shankar");
        owner1.setLastName("Palla");
        owner1.setId(1L);

        Owner owner2 = new Owner();
        owner2.setId(2l);
        owner2.setFirstName("Sivaram");
        owner2.setLastName("Pabolu");

        Pet pet1 = new Pet();
        PetType dog = new PetType();
        dog.setName("DOG");
        dog.setId(1L);
        pet1.setOwner(owner1);
        pet1.setPetType(dog);
        pet1.setId(1l);

        Pet pet2 = new Pet();
        pet2.setOwner(owner2);
        pet2.setPetType(dog);
        pet2.setId(2l);

        ownerService.save(owner1);
        ownerService.save(owner2);

    }
}
