package com.springboot.petclinic.springdatajpa;


import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.repositories.OwnerRepository;
import com.springboot.petclinic.repositories.PetRepository;
import com.springboot.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Smith";

    @Mock
     OwnerRepository ownerRepository;
    @Mock
     PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;


    Owner returnOwner;
    @BeforeEach
    void setUp() {
        returnOwner=new Owner();
        returnOwner.setId(1l);
        returnOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {

       Owner owner=new Owner();
       owner.setId(1l);
       owner.setLastName(LAST_NAME);
       when(ownerRepository.findByLastName(any())).thenReturn(owner);

       Owner john=service.findByLastName(LAST_NAME);
       assertEquals(LAST_NAME,john.getLastName());

    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        Owner owner1=new Owner();
        Owner owner2=new Owner();
        owner1.setId(1l);
        owner2.setId(2l);
        returnOwnersSet.add(owner1);
        returnOwnersSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        List<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }


    @Test
    void save() {
        Owner ownerToSave=new Owner();

        ownerToSave.setId(1l);


        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteByID(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}