package com.example.cookbook.recipesCategory.recipies;

import com.example.cookbook.recipesCategory.RecipeCategory;
import com.example.cookbook.recipesCategory.RecipeCategoryRepository;
import com.example.cookbook.recipesCategory.recipies.RecipeDescriptionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    RecipeDescriptionRepository recipeDescriptionRepository;
    RecipeRepository recipeRepository;
    RecipeCategoryRepository recipeCategoryRepository;

    public RecipeController(RecipeDescriptionRepository recipeDescriptionRepository, RecipeRepository recipeRepository,
                            RecipeCategoryRepository recipeCategoryRepository) {
        this.recipeDescriptionRepository = recipeDescriptionRepository;
        this.recipeRepository = recipeRepository;
        this.recipeCategoryRepository = recipeCategoryRepository;
    }

    @GetMapping("/categories/recipies/{id}")
    public String recipe(@PathVariable Long id, Model model) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        model.addAttribute("recipies", recipeRepository.findAll());
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());

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

    @GetMapping("/categories/recipies/dodaj")
    public String add(Model model) {
        Recipe recipe = new Recipe();
        RecipeCategory recipeCategory = new RecipeCategory();
        RecipeDescription recipeDescription = new RecipeDescription();
        int newIndex = recipeRepository.findAll().size();

        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("useRecipes", recipeRepository.findAll());
        model.addAttribute("addIdDescription", (newIndex + 1));
        model.addAttribute("useRecipeCategory", recipeCategory);
        model.addAttribute("createRecipe", recipe);
        model.addAttribute("createRecipeDescription", recipeDescription);
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        return "addRecipe";
    }

    @PostMapping("/categories/recipies/dodaj")
    public String add(Recipe recipe, RecipeDescription recipeDescription) {
        recipeRepository.save(recipe);
        recipeDescription.setDate(LocalDate.now());
        recipeDescription.setRecipe(recipe);
        recipeDescriptionRepository.save(recipeDescription);
        return "home";
    }
}
