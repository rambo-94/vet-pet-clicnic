package com.springboot.petclinic.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="vet_specalities",joinColumns = @JoinColumn(name = "vet_id"),
        inverseJoinColumns = @JoinColumn(name="specality_id"))
    private Set<Specialty> specialties = new HashSet<Specialty>();

    public Set<Specialty> getSpecialties() {

        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {

        this.specialties = specialties;
    }
}
