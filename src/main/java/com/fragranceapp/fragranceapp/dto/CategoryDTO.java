package com.fragranceapp.fragranceapp.dto;

import com.fragranceapp.fragranceapp.entity.enums.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Category category;

}
