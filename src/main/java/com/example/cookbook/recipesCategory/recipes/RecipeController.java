package com.example.cookbook.recipesCategory.recipes;

import com.example.cookbook.recipesCategory.RecipeCategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class RecipeController {

    RecipeRepository recipeRepository;
    RecipeCategoryRepository recipeCategoryRepository;


    public RecipeController(RecipeRepository recipeRepository,
                            RecipeCategoryRepository recipeCategoryRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeCategoryRepository = recipeCategoryRepository;
    }

    @GetMapping("/recipe/like/{id}")
    public String likeRecipe(@PathVariable Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            recipe.addLike();
            recipeRepository.save(recipe);
            return "redirect:/categories/recipes/{id}";
        } else {
            return "error";
        }
    }

    @GetMapping("/recipe/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        recipeRepository.deleteById(id);
        model.addAttribute("info", "Usunięto przepis o id: " + id + ".");
        return "recipeAddOrEditSuccess";
    }

    @GetMapping("/categories/recipes/{id}")
    public String recipe(@PathVariable Long id, Model model) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());


        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            model.addAttribute("recipe", recipe);
            return "recipes";
        } else {
            return "error";
        }
    }

    @GetMapping("/recipe/edit")
    public String edit(@RequestParam Long id, Model model) {
        recipeRepository.findById(id).ifPresent(recipe -> model.addAttribute("editRecipe", recipe));
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        return "recipeForm";
    }

    @GetMapping("/recipe/add")
    public String add(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("editRecipe", recipe);

        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        return "recipeForm";
    }

    @PostMapping("/recipe/edit")
    public String edit(Recipe recipe, Model model) {
        String attribute;
        if (recipe.getDate() == null) {
            attribute = "Dodawanie nowego przepisu zakończone sukcesem";
        } else {
            attribute = "Edycja przepisu zakończona sukcesem";
        }
        recipe.setDate(LocalDate.now());
        recipeRepository.save(recipe);
        model.addAttribute("info", attribute);
        return "recipeAddOrEditSuccess";
    }



}
