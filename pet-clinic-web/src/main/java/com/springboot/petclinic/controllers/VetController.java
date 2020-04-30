package com.springboot.petclinic.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vets")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {



    @RequestMapping(method = RequestMethod.GET,path = {"/",""})
    @CrossOrigin(origins = "http://localhost:4200")
    public String listVets(){
        return "{ \"name\": \"Shankar\", \"specialization\": \"Dogs\" }";

    }
}
