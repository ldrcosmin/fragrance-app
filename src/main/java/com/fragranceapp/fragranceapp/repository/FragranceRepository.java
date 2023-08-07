package com.fragranceapp.fragranceapp.repository;

import com.fragranceapp.fragranceapp.entity.enums.Category;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FragranceRepository extends JpaRepository<FragranceEntity, Long> {

    Optional<FragranceEntity> findFragranceById(long fragranceId);

    @Query(value = "select * from fragranceapp.fragrances f " +
            "inner join fragranceapp.categories c on f.category_id = c.cat_id " +
            "where c.cat_id = :categoryId", nativeQuery = true)
    List<FragranceEntity> getAllFragrancesByCategoryId(long categoryId);

}
