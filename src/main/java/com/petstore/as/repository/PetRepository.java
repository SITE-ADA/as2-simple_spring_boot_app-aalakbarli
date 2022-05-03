package com.petstore.as.repository;

import com.petstore.as.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Modifying
    @Query(value = "update Pet set name=?2, animal=?3 where pid=?1", nativeQuery = true)
    void update(Integer petId, String name, String animal);

    @Modifying
    @Query(value = "delete from PET_OWNERS where pid=?1", nativeQuery = true)
    void deletePetFromOwner(Integer id);
}
