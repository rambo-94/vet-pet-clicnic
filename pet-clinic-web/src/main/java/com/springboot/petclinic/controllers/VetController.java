package com.springboot.petclinic.controllers;

import com.springboot.petclinic.model.Vet;
import com.springboot.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vets")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {

    private VetService vetService;

    @Autowired
    public VetController(VetService vetService){


        this.vetService=vetService;
    }

    @RequestMapping(method = RequestMethod.GET,path = {"/",""})
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Vet> listVets(){



        return vetService.findAll();

    }
}
