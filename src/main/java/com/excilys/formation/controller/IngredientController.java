package com.excilys.formation.controller;

import com.excilys.formation.exception.IngredientControllerException;
import com.excilys.formation.exception.IngredientServiceException;
import com.excilys.formation.model.Ingredient;
import com.excilys.formation.service.IngredientService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
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

  @CrossOrigin
  @GetMapping(value = "/{id}", produces = "application/json")
  public @ResponseBody Ingredient getById(@PathVariable Long id) throws IngredientControllerException {
    try {
      return this.ingredientService.getById(id).get();
    } catch (IngredientServiceException ingredientServiceException) {
      throw new IngredientControllerException(ingredientServiceException.getMessage());
    }
  }
  
  @CrossOrigin
  @GetMapping(value = "/", produces = "application/json")
  public @ResponseBody List<Ingredient> getAll() throws IngredientControllerException {
    try {
      return this.ingredientService.getAll();
    } catch (IngredientServiceException ingredientServiceException) {
      throw new IngredientControllerException(ingredientServiceException.getMessage());
    }
  }

  @CrossOrigin
  @PostMapping(value = "/", produces = "application/json")
  public @ResponseBody Ingredient create(@RequestBody Ingredient ingredient) throws IngredientControllerException {
    try {

      return this.ingredientService.create(ingredient);
    } catch (IngredientServiceException ingredientServiceException) {
      throw new IngredientControllerException(ingredientServiceException.getMessage());
    }
  }

  @CrossOrigin
  @PatchMapping(value = "/", produces = "application/json")
  public @ResponseBody Ingredient update(@RequestBody Ingredient ingredient) throws IngredientControllerException {
    try {
      return this.ingredientService.update(ingredient);
    } catch (IngredientServiceException ingredientServiceException) {
      throw new IngredientControllerException(ingredientServiceException.getMessage());
    }
  }

  @CrossOrigin
  @DeleteMapping(value = "/", produces = "application/json")
  public @ResponseBody Ingredient delete(@RequestBody Ingredient ingredient) throws IngredientControllerException {
    try {
      return this.ingredientService.delete(ingredient);
    } catch (IngredientServiceException ingredientServiceException) {
      throw new IngredientControllerException(ingredientServiceException.getMessage());
    }
  }

  @CrossOrigin
  @DeleteMapping(value = "/{id}", produces = "application/json")
  public @ResponseBody Ingredient deleteById(@PathVariable Long id) throws IngredientControllerException {
    try {
      return this.ingredientService.deleteById(id);
    } catch (IngredientServiceException ingredientServiceException) {
      throw new IngredientControllerException(ingredientServiceException.getMessage());
    }
  }
}
