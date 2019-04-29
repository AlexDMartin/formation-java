package com.excilys.formation.service;

import com.excilys.formation.dao.RecipeDao;
import com.excilys.formation.exception.RecipeDaoException;
import com.excilys.formation.exception.RecipeServiceException;
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

  public Optional<Recipe> getById(long id) throws RecipeServiceException {
    try {
      return this.recipeDao.getById(id);
    } catch (RecipeDaoException recipeDaoException) {
      throw new RecipeServiceException(recipeDaoException.getMessage());
    }
  }

  public List<Recipe> getAll() throws RecipeServiceException {
    try {
      return this.recipeDao.getAll();
    } catch (RecipeDaoException recipeDaoException) {
      throw new RecipeServiceException(recipeDaoException.getMessage());
    }
  }

  @Transactional
  public Recipe create(Recipe recipe) throws RecipeServiceException {
    try {
      return this.recipeDao.create(recipe);
    } catch (RecipeDaoException recipeDaoException) {
      throw new RecipeServiceException(recipeDaoException.getMessage());
    }
  }

  @Transactional
  public Recipe update(Recipe recipe) throws RecipeServiceException {
    try {
      return this.recipeDao.update(recipe);
    } catch (RecipeDaoException recipeDaoException) {
      throw new RecipeServiceException(recipeDaoException.getMessage());
    }
  }

  @Transactional
  public Recipe delete(Recipe recipe) throws RecipeServiceException {
    try {
      return this.recipeDao.delete(recipe);
    } catch (RecipeDaoException recipeDaoException) {
      throw new RecipeServiceException(recipeDaoException.getMessage());
    }
  }

  @Transactional
  public Recipe deleteById(long id) throws RecipeServiceException {
    try {
      return this.recipeDao.deleteById(id);
    } catch (RecipeDaoException recipeDaoException) {
      throw new RecipeServiceException(recipeDaoException.getMessage());
    }
  }
}
