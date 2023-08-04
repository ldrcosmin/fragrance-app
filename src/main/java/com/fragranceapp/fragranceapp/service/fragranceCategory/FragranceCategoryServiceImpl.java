package com.fragranceapp.fragranceapp.service.fragranceCategory;

import com.fragranceapp.fragranceapp.mapper.Mapper;
import com.fragranceapp.fragranceapp.dto.CategoryDTO;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceCategoryEntity;
import com.fragranceapp.fragranceapp.exceptions.categoryExceptions.FragranceCategoryNotFoundException;
import com.fragranceapp.fragranceapp.repository.FragranceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FragranceCategoryServiceImpl implements FragranceCategoryService {

    private FragranceCategoryRepository fragranceCategoryRepository;

    @Autowired
    public FragranceCategoryServiceImpl(FragranceCategoryRepository fragranceCategoryRepository) {
        this.fragranceCategoryRepository = fragranceCategoryRepository;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO newCategory) {
       FragranceCategoryEntity fragranceCategoryEntity = Mapper.mapToEntity(newCategory);
       fragranceCategoryRepository.save(fragranceCategoryEntity);

       return newCategory;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<FragranceCategoryEntity> categories = fragranceCategoryRepository.findAll();
        List<CategoryDTO> categoriesDTO = categories.stream()
                .map(entity -> Mapper.mapToDto(entity))
                .collect(Collectors.toList());

        return categoriesDTO;
    }

    @Override
    public CategoryDTO getCategoryById(long cateogryId) {
        Optional<FragranceCategoryEntity> category = fragranceCategoryRepository.findCategoryById(cateogryId);
        if(category.isEmpty()) {
            throw new FragranceCategoryNotFoundException("The category with id " + cateogryId + " doesn't exist");
        }

        return Mapper.mapToDto(category.get());
    }

    @Override
    public CategoryDTO updateCategory(long categoryId, CategoryDTO updateCategory) {
        Optional<FragranceCategoryEntity> category = fragranceCategoryRepository.findCategoryById(categoryId);
        if(category.isEmpty()) {
            throw new FragranceCategoryNotFoundException("The category with id " + categoryId + " doesn't exist");
        }
        category.get().setCategory(updateCategory.getCategory());
        fragranceCategoryRepository.save(category.get());

        return Mapper.mapToDto(category.get());
    }

    @Override
    public void deleteCategory(long categoryId) {
        Optional<FragranceCategoryEntity> category = fragranceCategoryRepository.findCategoryById(categoryId);
        if(category.isEmpty()) {
            throw new FragranceCategoryNotFoundException("The category with id " + categoryId + " doesn't exist");
        }

        fragranceCategoryRepository.deleteById(categoryId);
    }
}
