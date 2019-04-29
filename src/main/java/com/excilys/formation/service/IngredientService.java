package com.excilys.formation.service;

import com.excilys.formation.dao.IngredientDao;
import com.excilys.formation.model.Ingredient;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredientService {
  
  private IngredientDao ingredientDao; 
  
  public IngredientService(IngredientDao ingredientDao) {
    this.ingredientDao = ingredientDao;
  }
  
  public Optional<Ingredient> getById(long id) {
    return this.ingredientDao.getById(id);
  }
  
  public List<Ingredient> getAll() {
    return this.ingredientDao.getAll();
  }
  
  @Transactional
  public Ingredient create(Ingredient ingredient) {
    return this.ingredientDao.create(ingredient);
  }

  @Transactional
  public Ingredient update(Ingredient ingredient) {
    return this.ingredientDao.update(ingredient);
  }
  
  @Transactional
  public Ingredient delete(Ingredient ingredient) {
    return this.ingredientDao.delete(ingredient);
  }
  
  @Transactional
  public Ingredient deleteById(long ingredient) {
    return this.ingredientDao.deleteById(ingredient);
  }
  
}
