package com.excilys.formation.controller;

import com.excilys.formation.model.Recipe;
import com.excilys.formation.service.RecipeService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recipes")
public class RecipeController {
  
  private RecipeService recipeService;
  
  private RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public @ResponseBody Recipe get(@PathVariable Long id) {
    return this.recipeService.getById(id).get();
  }
  
  @GetMapping(value = "/", produces = "application/json")
  public @ResponseBody List<Recipe> getAll() {
    return this.recipeService.getAll();
  }
  
  @PostMapping(value = "/", produces = "application/json")
  public @ResponseBody Recipe create(@RequestBody Recipe recipe) {
    return this.recipeService.create(recipe);
  }
  
  @PatchMapping(value = "/", produces = "application/json")
  public @ResponseBody Recipe update(@RequestBody Recipe recipe) {
    return this.recipeService.update(recipe);
  }
  
  @DeleteMapping(value = "/", produces = "application/json")
  public @ResponseBody Recipe delete(@RequestBody Recipe recipe) {
    return this.recipeService.delete(recipe);
  }
  
  @DeleteMapping(value = "/{id}", produces = "application/json")
  public @ResponseBody Recipe deleteById(@PathVariable Long id) {
   return this.recipeService.deleteById(id);
  }
}
