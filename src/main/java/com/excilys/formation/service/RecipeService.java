package com.excilys.formation.service;

import com.excilys.formation.dao.RecipeDao;
import com.excilys.formation.model.Recipe;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeService {

  private RecipeDao recipeDao;
  
  public RecipeService(RecipeDao recipeDao) {
    this.recipeDao = recipeDao;
  }
  
  public Optional<Recipe> getById(long id) {
    return this.recipeDao.getById(id);
  }
  
  public List<Recipe> getAll() {
    return this.recipeDao.getAll();
  }
  
  @Transactional
  public Recipe create(Recipe recipe) {
    return this.recipeDao.create(recipe);
  }
  
  @Transactional
  public Recipe update(Recipe recipe) {
    return this.recipeDao.update(recipe);
  }
  
  @Transactional
  public Recipe delete(Recipe recipe) {
    return this.recipeDao.delete(recipe);
  }
  
  @Transactional
  public Recipe deleteById(long id) {
    return this.recipeDao.deleteById(id);
  }
}
