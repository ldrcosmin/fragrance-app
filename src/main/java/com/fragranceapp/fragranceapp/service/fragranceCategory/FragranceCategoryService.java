package com.fragranceapp.fragranceapp.service.fragranceCategory;

import com.fragranceapp.fragranceapp.dto.CategoryDTO;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceCategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FragranceCategoryService {

    CategoryDTO createCategory(CategoryDTO newCategory);
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(long categoryId);
    CategoryDTO updateCategory(long categoryId, CategoryDTO updateCategory);
    void deleteCategory(long categoryId);
}
