package com.example.cookbook.recipe;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private RecipeDtoMapper recipeDtoMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeDtoMapper recipeDtoMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeDtoMapper = recipeDtoMapper;
    }

    RecipeDto getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .map(recipeDtoMapper::map).get();
    }

    public void addLike(Long id) {
        RecipeDto recipeDto = getRecipeById(id);
        Recipe recipe = recipeRepository.findById(recipeDto.getId()).get(); //czy nie jest zla praktyka od razu pominac ta linie i odwolac sie do recipe.liked?
        recipe.setLikedRecipe(recipe.getLikedRecipe() + 1);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public String setDataInRecipe(RecipeDto recipeDto) {
        String attribute;
        if (recipeDto.getDate() == null) {
            saveRecipe(recipeDto, new Recipe());
            attribute = "Dodawanie nowego przepisu zakończone sukcesem";
        } else {
            Recipe recipe = recipeRepository.findById(recipeDto.getId()).get();
            saveRecipe(recipeDto, recipe);
            attribute = "Edycja przepisu zakończona sukcesem";
        }
        return attribute;
    }

    private void saveRecipe(RecipeDto recipeDto, Recipe recipe) {
        recipe.setCategory(recipeDto.getCategory());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setRecipeImgUrl(recipeDto.getRecipeImgUrl());
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setInstruction(recipeDto.getInstruction());
        recipe.setName(recipeDto.getName());
        recipe.setPrepareTime(recipeDto.getPrepareTime());
        recipeRepository.save(recipe);
    }

    public int recipesListSize() {
        return recipeRepository.findAll().size();
    }
}
