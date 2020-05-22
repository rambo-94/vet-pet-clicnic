package com.springboot.petclinic.controllers;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.model.Pet;
import com.springboot.petclinic.model.PetType;
import com.springboot.petclinic.model.Visit;
import com.springboot.petclinic.service.OwnerService;
import com.springboot.petclinic.service.PetService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owners")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {

    private final OwnerService ownerService;
    private final PetService petService;
    public OwnerController(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields (WebDataBinder dataBinder){

           dataBinder.setDisallowedFields("id");

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET,path = {"/",""})
    public List<Owner> listOwners(){

       List<Owner> owners=ownerService.findAll();
        return owners;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = {RequestMethod.GET},path = {"/find"})
    public List<Owner> findOwnerslike(Owner owner, BindingResult result, Map<String, Object> model) {

        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = this.ownerService.findAllByLastName("%" + owner.getLastName()+"%");

        if (results.isEmpty()) {

            return null;
        }else{
            return results;
        }
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{ownerId}")
    public Owner findOwnerByID(@PathVariable("ownerId") Long id ){
         Owner owner=ownerService.findById(id);

        return owner;
    }


    @RequestMapping(method = RequestMethod.PUT,path = "/owners/new")
    @CrossOrigin(origins = "http://localhost:4200")
    public String addNewOwner(@Valid Owner owner) {

            Owner savedOwner=this.ownerService.save(owner);
            if(savedOwner!=null){

                return "success";

            }else {
                return "error saving owner";
            }

    }
    @RequestMapping(method = RequestMethod.POST,path = "/owners/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId) {

            owner.setId(ownerId);
            Owner updatedOwner=this.ownerService.save(owner);
            if(updatedOwner !=null){

                return "success";
            }else {

                return "error saving owner";
            }
        }
}

