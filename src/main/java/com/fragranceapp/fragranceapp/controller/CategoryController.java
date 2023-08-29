package com.fragranceapp.fragranceapp.controller;

import com.fragranceapp.fragranceapp.dto.CategoryDTO;
import com.fragranceapp.fragranceapp.service.fragranceCategory.FragranceCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private FragranceCategoryServiceImpl fragranceCategoryService;

    @Autowired
    public CategoryController(FragranceCategoryServiceImpl fragranceCategoryService) {
        this.fragranceCategoryService = fragranceCategoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable long id) {
        CategoryDTO categoryDTO = fragranceCategoryService.getCategoryById(id);

        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
       List<CategoryDTO> categories =  fragranceCategoryService.getAllCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = fragranceCategoryService.createCategory(categoryDTO);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable long id, @RequestBody CategoryDTO newCategory) {
        CategoryDTO categoryDTO = fragranceCategoryService.updateCategory(id, newCategory);

        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id) {
        fragranceCategoryService.deleteCategory(id);

        return ResponseEntity.ok().build();
    }
}
