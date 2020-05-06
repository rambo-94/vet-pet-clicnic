package com.springboot.petclinic.bootstrap;

import com.springboot.petclinic.model.*;
import com.springboot.petclinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private OwnerService ownerService;
    private PetService petService;
    private VetService vetService;
    private PetTypeService petTypeService;
    private SpecialtyService specialtyService;
    private VisitService visitService;

    @Autowired
    public void DataLoader(OwnerService ownerService,PetService petService,VetService vetService,PetTypeService petTypeService,SpecialtyService specialtyService,VisitService visitService) {

        this.ownerService=ownerService;
        this.petService=petService;
        this.vetService=vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService= visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Shankar");
        owner1.setLastName("Palla");
        owner1.setAddress("254 clever Boulevard");
        owner1.setCity("Cincinnati");
        owner1.setTelephone("97867674");

        Owner owner2 = new Owner();
        owner2.setFirstName("Sivaram");
        owner2.setLastName("Pabolu");
        owner1.setAddress("4820 Paseo Boulevard");
        owner1.setCity("Kansas City");
        owner1.setTelephone("032954389");

        Pet shankarDog = new Pet();
        PetType dog = new PetType();
        dog.setName("DOG");
        PetType petTypeDog=petTypeService.save(dog);

        shankarDog.setOwner(owner1);
        shankarDog.setPetType(petTypeDog);
        shankarDog.setName("Tommy");
        shankarDog.setBirthDate(LocalDate.now());
        owner1.getPets().add(shankarDog);

        Pet sivaCat = new Pet();
        PetType cat = new PetType();
        cat.setName("cat");
        PetType petTypeCat=petTypeService.save(cat);
        sivaCat.setOwner(owner2);
        sivaCat.setPetType(petTypeCat);
        sivaCat.setName("Whitty");
        sivaCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(sivaCat);

        ownerService.save(owner1);
        ownerService.save(owner2);

        Visit dogVisit=new Visit();
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("General Visit");
        dogVisit.setPet(shankarDog);
        visitService.save(dogVisit);

        Specialty radiology=new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology= specialtyService.save(radiology);

        Specialty surgery=new Specialty();
        radiology.setDescription("surgery");
        Specialty savedSurgery= specialtyService.save(surgery);

        Specialty dentistry=new Specialty();
        radiology.setDescription("dentistry");
        Specialty savedDentistry= specialtyService.save(dentistry);

        Vet vet1=new Vet();
        vet1.setFirstName("Sriram");
        vet1.setLastName("Narkedamilli");
        vet1.getSpecialties().add(savedRadiology);


        Vet vet2=new Vet();
        vet2.setFirstName("Sandy");
        vet2.setLastName("Meesala");
        vet2.getSpecialties().add(savedDentistry);


        vetService.save(vet1);
        vetService.save(vet2);
    }
}
