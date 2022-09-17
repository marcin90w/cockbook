package com.example.cookbook.category;

import com.example.cookbook.recipe.RecipeDto;
import com.example.cookbook.recipe.RecipeRepository;
import com.example.cookbook.recipe.Recipe;
import com.example.cookbook.recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    CategoryService categoryService;
    RecipeService recipeService;

    public CategoryController(CategoryService categoryService, RecipeService recipeService) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
    }

/*    @GetMapping("categories/{id}")
    public String category(@PathVariable Long id, Model model) {
        Optional<Category> recipeCategoryOptional = recipeCategoryRepository.findById(id);
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());

        if(recipeCategoryOptional.isPresent()) {
            Category recipeCategory = recipeCategoryOptional.get();

            List<Recipe> byRecipe = recipeRepository.findByRecipeCategory(recipeCategory);
            model.addAttribute("recipes", byRecipe);
            model.addAttribute("category", recipeCategory);
            return "categories";
        } else {
            return "error";
        }
    }*/
}
