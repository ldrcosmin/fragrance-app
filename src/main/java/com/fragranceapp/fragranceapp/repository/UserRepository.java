package com.fragranceapp.fragranceapp.repository;

import com.fragranceapp.fragranceapp.entity.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserById(long userId);

    Optional<UserEntity> findUserByEmail(String userEmail);

}
