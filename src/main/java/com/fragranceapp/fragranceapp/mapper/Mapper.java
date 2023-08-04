package com.fragranceapp.fragranceapp.mapper;

import com.fragranceapp.fragranceapp.dto.CategoryDTO;
import com.fragranceapp.fragranceapp.dto.FragranceDTO;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceCategoryEntity;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceEntity;

import java.time.LocalDateTime;

public class Mapper {

    public static CategoryDTO mapToDto(FragranceCategoryEntity fragranceCategoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategory(fragranceCategoryEntity.getCategory());

        return categoryDTO;
    }

    public static FragranceCategoryEntity mapToEntity(CategoryDTO categoryDTO) {
        FragranceCategoryEntity fragranceCategoryEntity = new FragranceCategoryEntity();
        fragranceCategoryEntity.setCategory(categoryDTO.getCategory());
        fragranceCategoryEntity.setCreated_at(LocalDateTime.now());
        fragranceCategoryEntity.setUpdated_at(LocalDateTime.now());

        return fragranceCategoryEntity;
    }


}
