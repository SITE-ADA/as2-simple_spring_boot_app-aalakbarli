package com.petstore.as.repository;

import com.petstore.as.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    @Modifying
    @Query(value = "delete from PET_OWNERS where oid=?1", nativeQuery = true)
    void deletePetsOfOwner(Integer id);

    @Modifying
    @Query(value = "delete from PET_OWNERS where oid=?1 and pid=?2", nativeQuery = true)
    void deleteOwnerPet(Integer ownerId, Integer petId);
}
