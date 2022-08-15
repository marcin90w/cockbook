package com.example.cookbook;

import com.example.cookbook.recipesCategory.RecipeCategory;
import com.example.cookbook.recipesCategory.RecipeCategoryRepository;
import com.example.cookbook.recipesCategory.recipies.Recipe;
import com.example.cookbook.recipesCategory.recipies.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        return "home";
    }
}