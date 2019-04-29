package com.excilys.formation.controller;

import com.excilys.formation.model.Ingredient;
import com.excilys.formation.service.IngredientService;
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
@RequestMapping("ingredients")
public class IngredientController {

  private IngredientService ingredientService;
  
  private IngredientController(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public @ResponseBody Ingredient getById(@PathVariable Long id) {
    return this.ingredientService.getById(id).get();
  }
  
  @GetMapping(value = "/", produces = "application/json")
  public @ResponseBody List<Ingredient> getAll() {
    return this.ingredientService.getAll();
  }
  
  @PostMapping(value = "/", produces = "application/json")
  public @ResponseBody Ingredient create(@RequestBody Ingredient ingredient) {
    this.ingredientService.create(ingredient);
    return ingredient; 
  }
  
  @PatchMapping(value = "/", produces = "application/json")
  public @ResponseBody Ingredient update(@RequestBody Ingredient ingredient) {
    this.ingredientService.update(ingredient);
    return ingredient;
  }
  
  @DeleteMapping(value = "/", produces = "application/json")
  public @ResponseBody Ingredient delete(@RequestBody Ingredient ingredient) {
    this.ingredientService.delete(ingredient);
    return ingredient;
  }
  
  @DeleteMapping(value = "/{id}", produces = "application/json")
  public @ResponseBody Ingredient deleteById(@PathVariable Long id) {
    return this.ingredientService.deleteById(id);
  }
}
