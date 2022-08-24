package com.example.cookbook;

import com.example.cookbook.recipesCategory.RecipeCategory;
import com.example.cookbook.recipesCategory.RecipeCategoryRepository;
import com.example.cookbook.recipesCategory.recipes.Recipe;
import com.example.cookbook.recipesCategory.recipes.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {

    private RecipeCategoryRepository recipeCategoryRepository;
    RecipeRepository recipeRepository;

    public HomeController(RecipeCategoryRepository recipeCategoryRepository, RecipeRepository recipeRepository) {
        this.recipeCategoryRepository = recipeCategoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
//        Optional<RecipeCategory> input = recipeCategoryRepository.findFirstByOrderByTitleDesc();
//        Optional<Recipe> example = recipeRepository.findFirstByOrderByLikedRecipeDesc();
//        if (example != null) {
//            model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
//            model.addAttribute("highestRatedRecipe", example.get());
//        } else {
//            return "recipeForm";
//        }
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        model.addAttribute("highestRatedRecipe", recipeRepository.findFirstByOrderByLikedRecipeDesc());

        return "home";
    }
}