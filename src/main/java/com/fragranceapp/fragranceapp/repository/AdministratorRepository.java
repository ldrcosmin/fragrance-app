package com.fragranceapp.fragranceapp.repository;

import com.fragranceapp.fragranceapp.entity.persistence.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<AdministratorEntity, Long> {

   @Query(value = "select * from fragranceapp.administrators a " +
            "inner join fragranceapp.users u on a.user_id = u.usr_id " +
            "where u.email = :userEmail", nativeQuery = true)
    Optional<AdministratorEntity> findAdministratorByEmail(String userEmail);

}
