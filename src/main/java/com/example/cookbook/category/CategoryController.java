package com.example.cookbook.category;

import com.example.cookbook.recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    CategoryService categoryService;
    RecipeService recipeService;

    public CategoryController(CategoryService categoryService, RecipeService recipeService) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
    }

    @GetMapping("categories/{id}")
    public String category(@PathVariable Long id, Model model) {
        CategoryDto recipeCategory = categoryService.getCategoryInfo(id);
        model.addAttribute("categories", categoryService.getCategoryList()); // model wykorzystywany przez layout.html

        if(recipeCategory != null) {
            model.addAttribute("recipes", categoryService.getRecipesByCategoryId(id));
            model.addAttribute("category", recipeCategory);
            return "categories";
        } else {
            return "error";
        }
    }
}
