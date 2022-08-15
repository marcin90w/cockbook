package com.example.cookbook.Repository;

import com.example.cookbook.data.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class RecipeCategoryController {

    RecipeCategoryRepository recipeCategoryRepository;
    RecipeRepository recipeRepository;

    public RecipeCategoryController(RecipeCategoryRepository recipeCategoryRepository, RecipeRepository recipeRepository) {
        this.recipeCategoryRepository = recipeCategoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("categories/{id}")
    public String category(@PathVariable Long id, Model model) {
        Optional<RecipeCategory> recipeCategoryOptional = recipeCategoryRepository.findById(id);
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());

        if(recipeCategoryOptional.isPresent()) {
            RecipeCategory recipeCategory = recipeCategoryOptional.get();

            List<Recipe> byRecipe = recipeRepository.findByRecipeCategory(recipeCategory);
            model.addAttribute("recipies", byRecipe);
            model.addAttribute("category", recipeCategory);
            return "categories";
        } else {
            return "error";
        }
    }
}
