package com.petstore.as.model;

import javax.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PID", unique = true)
    private Integer petId;
    private String animal;
    private String name;
    @ManyToOne
    @JoinTable(name = "PET_OWNERS", joinColumns = @JoinColumn(name = "PID"), inverseJoinColumns = @JoinColumn(name = "OID"))
    private Owner owner;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer pet_id) {
        this.petId = pet_id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "petId=" + petId +
                ", animal='" + animal + '\'' +
                ", name='" + name + '\'';
    }
}
