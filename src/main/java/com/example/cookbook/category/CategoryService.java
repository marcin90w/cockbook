package com.example.cookbook.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    CategoryDtoMapper categoryDtoMapper;
    CategoryRepository categoryRepository;

    public CategoryService(CategoryDtoMapper categoryDtoMapper, CategoryRepository categoryRepository) {
        this.categoryDtoMapper = categoryDtoMapper;
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getCategoryList() {
        return categoryRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private CategoryDto toDto(Category category) {
        return categoryDtoMapper.map(category);

    }
}
