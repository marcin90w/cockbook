package com.example.cookbook;

import com.example.cookbook.category.CategoryRepository;
import com.example.cookbook.category.CategoryService;
import com.example.cookbook.recipe.RecipeRepository;
import com.example.cookbook.recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    CategoryService categoryService;
    RecipeService recipeService;

    public HomeController(CategoryService categoryService, RecipeService recipeService) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("recipeCategories", categoryService.getCategoryList());
//        model.addAttribute("highestRatedRecipe", recipeService.findFirstByOrderByLikedRecipeDesc());

        return "home";
    }
}