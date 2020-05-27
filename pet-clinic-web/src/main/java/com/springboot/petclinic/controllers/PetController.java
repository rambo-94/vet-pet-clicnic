package com.springboot.petclinic.controllers;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.model.Pet;
import com.springboot.petclinic.model.PetType;
import com.springboot.petclinic.service.OwnerService;
import com.springboot.petclinic.service.PetService;
import com.springboot.petclinic.service.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/owners/{ownerId}")
public class PetController {


    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    public Collection<PetType> populatePetTypes() {
        return this.petTypeService.findAll();
    }

    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return this.ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(method = RequestMethod.POST,path = "/pets/new")
    @CrossOrigin(origins = "https://localhost:8080")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }

        Pet savedPet = petService.save(pet);
        if (savedPet != null) {
            return "Success";
        }else{


            return "failure adding pets";
        }
    }

    @PostMapping(value = "/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, ModelMap model) {

            owner.getPets().add(pet);
            Pet savedPet = petService.save(pet);
            if (savedPet != null) {
            return "Success";
            }else{
            return "failure updating pets";
            }
        }


}




