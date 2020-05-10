package com.springboot.petclinic.controllers;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.HashSet;
import java.util.Set;



class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner owner1=new Owner();
        owner1.setId(1l);
        Owner owner2=new Owner();
        owner2.setId(1l);
        owners.add(owner1);
        owners.add(owner2);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
    @Test
    void listOwners() throws Exception {

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk());


    }

    @Test
    void findOwner() throws Exception {

        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk());

    }
}