package com.fragranceapp.fragranceapp.dto;

import com.fragranceapp.fragranceapp.entity.enums.Category;
import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {

    private Category category;

    public CategoryDTO() {

    }

    public CategoryDTO(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
