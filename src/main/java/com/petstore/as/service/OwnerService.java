package com.petstore.as.service;

import com.petstore.as.model.Owner;
import com.petstore.as.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Integer ownerId) {
        return ownerRepository.getById(ownerId);
    }

    public void create(Owner owner) {
        ownerRepository.save(owner);
    }

    public void deleteOwnerById(Integer id) {
        ownerRepository.deletePetsOfOwner(id);
        ownerRepository.deleteById(id);
    }

    public void deleteOwnerPet(Integer ownerId, Integer petId) {
        ownerRepository.deleteOwnerPet(ownerId, petId);
    }
}
