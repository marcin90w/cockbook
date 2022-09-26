package com.example.cookbook.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryDtoMapper {
    CategoryDto map(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setDescription(category.getDescription());
        dto.setId(category.getId());
        dto.setImgUrl(category.getImgUrl());
        dto.setType(category.getType());
        return dto;
    }
}
