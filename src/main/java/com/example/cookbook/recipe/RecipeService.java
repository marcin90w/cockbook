package com.example.cookbook.recipe;

import org.springframework.stereotype.Service;

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
        Recipe recipe = recipeRepository.findById(recipeDto.getId()).get();
        recipe.setLikedRecipe(recipe.getLikedRecipe() + 1);
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public String updateOrSaveRecipe(RecipeDto recipeDto) {
        String attribute;
        if (recipeDto.getDate() == null) {
            setDataForRecipe(recipeDto, new Recipe());
            attribute = "Dodawanie nowego przepisu zakończone sukcesem";
        } else {
            Recipe recipe = recipeRepository.findById(recipeDto.getId()).get();
            setDataForRecipe(recipeDto, recipe);
            attribute = "Edycja przepisu zakończona sukcesem";
        }
        return attribute;
    }

    private void setDataForRecipe(RecipeDto recipeDto, Recipe recipe) {
        recipe.setCategory(recipeDto.getCategory());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setRecipeImgUrl(recipeDto.getRecipeImgUrl());
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setInstruction(recipeDto.getInstruction());
        recipe.setName(recipeDto.getName());
        recipe.setPrepareTime(recipeDto.getPrepareTime());
        recipeRepository.save(recipe);
    }

    public Long recipesListSize() {
        return recipeRepository.count();
    }

    public RecipeDto findHighLikedRecipe() {
        if (recipeRepository.count() > 0) {
            return recipeDtoMapper.map(recipeRepository.findFirstByOrderByLikedRecipeDesc());
        } else {
            return new RecipeDto();
        }
    }
}
