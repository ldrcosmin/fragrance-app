package com.fragranceapp.fragranceapp.repository;

import com.fragranceapp.fragranceapp.entity.persistence.FragranceCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FragranceCategoryRepository extends JpaRepository<FragranceCategoryEntity, Long> {

    Optional<FragranceCategoryEntity> findCategoryById(long categoryId);
}
