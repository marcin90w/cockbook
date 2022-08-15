package com.example.cookbook.recipesCategory.recipies;

import com.example.cookbook.recipesCategory.recipies.RecipeDescriptionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    RecipeDescriptionRepository recipeDescriptionRepository;
    RecipeRepository recipeRepository;

    public RecipeController(RecipeDescriptionRepository recipeDescriptionRepository, RecipeRepository recipeRepository) {
        this.recipeDescriptionRepository = recipeDescriptionRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/categories/recipies/{id}")
    public String recipe(@PathVariable Long id, Model model) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        model.addAttribute("recipies", recipeRepository.findAll());

        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();

            List<RecipeDescription> recipeDescriptionList = recipeDescriptionRepository.findByRecipe(recipe);
            model.addAttribute("descriptions", recipeDescriptionList);
            model.addAttribute("recipe", recipe);
            return "recipies";
        } else {
            return "error";
        }


    }
}
