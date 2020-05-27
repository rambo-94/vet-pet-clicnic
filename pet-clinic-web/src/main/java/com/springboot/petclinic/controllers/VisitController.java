package com.springboot.petclinic.controllers;

import com.springboot.petclinic.model.Visit;
import com.springboot.petclinic.service.PetService;
import com.springboot.petclinic.service.VisitService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController

public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @PostMapping(value = "pets/{petId}/visits/new")
    public void  saveNewVisit(@Valid Visit visit) {

            this.visitService.save(visit);


    }

    @GetMapping(value = "pets/{petId}/visits")
    public void showVisits(@PathVariable Long petId, Map<String, Object> model) {
        this.petService.findById(petId).getVisits();
    }

}
