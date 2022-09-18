package com.example.cookbook;

import com.example.cookbook.category.CategoryService;
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
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("recipeCategories", categoryService); // aby pobrac informacje o ilosciach przepisow w tablicy kategorii na home.html
//        model.addAttribute("highestRatedRecipe", recipeService.findFirstByOrderByLikedRecipeDesc());
        return "home";
    }
}