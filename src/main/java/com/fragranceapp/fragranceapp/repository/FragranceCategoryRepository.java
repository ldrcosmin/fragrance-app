package com.fragranceapp.fragranceapp.repository;

import com.fragranceapp.fragranceapp.entity.persistence.FragranceCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FragranceCategoryRepository extends JpaRepository<FragranceCategoryEntity, Long> {

    Optional<FragranceCategoryEntity> findCategoryById(long categoryId);
}
