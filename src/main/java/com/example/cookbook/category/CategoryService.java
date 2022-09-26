package com.example.cookbook.category;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    CategoryDtoMapper categoryDtoMapper;
    CategoryRepository categoryRepository;
    RecipeByCategoryMapperDto recipeByCategoryMapperDto;

    public CategoryService(CategoryDtoMapper categoryDtoMapper, CategoryRepository categoryRepository,
                           RecipeByCategoryMapperDto recipeByCategoryMapperDto) {
        this.categoryDtoMapper = categoryDtoMapper;
        this.categoryRepository = categoryRepository;
        this.recipeByCategoryMapperDto = recipeByCategoryMapperDto;
    }

    public List<CategoryDto> getCategoryList() {
        return categoryRepository
                .findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private CategoryDto toDto(Category category) {
        return categoryDtoMapper.map(category);
    }

    public List<RecipeByCategoryDto> getRecipesByCategoryId(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(Category::getRecipes)
                .orElse(Collections.emptyList())
                .stream().map(recipeByCategoryMapperDto::map)
                .toList();
    }

    public CategoryDto getCategoryInfo(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(categoryDtoMapper::map)
                .get();
    }
}
