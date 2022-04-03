package com.petstore.as.service;

import com.petstore.as.model.Pet;
import com.petstore.as.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetService {
    @Autowired
    private PetRepository petRepository;
    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public Pet getPetById(Integer id) {
        return petRepository.getById(id);
    }

    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    public void updatePet(Pet pet) {
        petRepository.update(pet.getPetId(), pet.getName(), pet.getAnimal());
    }

    public void deletePetById(Integer id) {
        petRepository.deletePetFromOwner(id);
        petRepository.deleteById(id);
    }

    public void removeFromOwner(Integer id) {
        petRepository.deletePetFromOwner(id);
    }
}
