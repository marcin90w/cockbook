package com.example.cookbook.recipe;

import com.example.cookbook.category.CategoryRepository;
import com.example.cookbook.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    CategoryService categoryService;
    RecipeService recipeService;



    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

/*    @GetMapping("/recipe/like/{id}")
    public String likeRecipe(@PathVariable Long id) {
        Optional<Recipe> recipeOptional = recipeService.findById(id);
        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            recipe.addLike();
            recipeService.save(recipe);
            return "redirect:/categories/recipes/{id}";
        } else {
            return "error";
        }
    }*/

/*    @GetMapping("/recipe/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        recipeService.deleteById(id);
        model.addAttribute("info", "Usunięto przepis o id: " + id + ".");
        return "recipeAddOrEditSuccess";
    }*/

    @GetMapping("/categories/recipes/{id}")
    String getRecipe(@PathVariable Long id, Model model) {
        Optional<RecipeDto> recipeDtoOptional = recipeService.getRecipeById(id);
        if (recipeDtoOptional.isPresent()) {
            RecipeDto recipeDto = recipeDtoOptional.get();
            model.addAttribute("recipeDto", recipeDto);
            return "recipes";
        } else {
            return "error";
        }
    }

/*    @GetMapping("/recipe/edit")
    public String edit(@RequestParam Long id, Model model) {
        recipeService.findById(id).ifPresent(recipe -> model.addAttribute("editRecipe", recipe));
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        return "recipeForm";
    }*/

/*
    @GetMapping("/recipe/add")
    public String add(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("editRecipe", recipe);

        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        return "recipeForm";
    }
*/

/*
    @PostMapping("/recipe/edit")
    public String edit(Recipe recipe, Model model) {
        String attribute;
        if (recipe.getDate() == null) {
            attribute = "Dodawanie nowego przepisu zakończone sukcesem";
        } else {
            attribute = "Edycja przepisu zakończona sukcesem";
        }
        recipe.setDate(LocalDate.now());
        recipeService.save(recipe);
        model.addAttribute("info", attribute);
        return "recipeAddOrEditSuccess";
    }
*/



}
