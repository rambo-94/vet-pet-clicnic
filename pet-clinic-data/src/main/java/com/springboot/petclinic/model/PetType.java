package com.springboot.petclinic.model;


import org.springframework.data.annotation.TypeAlias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="types")
public class PetType extends BaseEntity{

    @Column(name="name")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
