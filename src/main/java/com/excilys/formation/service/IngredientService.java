package com.excilys.formation.service;

import com.excilys.formation.dao.IngredientDao;
import com.excilys.formation.exception.IngredientDaoException;
import com.excilys.formation.exception.IngredientServiceException;
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

  public Optional<Ingredient> getById(long id) throws IngredientServiceException {
    try {
      return this.ingredientDao.getById(id);
    } catch (IngredientDaoException ingredientDaoException) {
      throw new IngredientServiceException(ingredientDaoException.getMessage());
    }
  }

  public List<Ingredient> getAll() throws IngredientServiceException {
    try {
      return this.ingredientDao.getAll();
    } catch (IngredientDaoException ingredientDaoException) {
      throw new IngredientServiceException(ingredientDaoException.getMessage());
    }
  }

  @Transactional
  public Ingredient create(Ingredient ingredient) throws IngredientServiceException {
    try {
      return this.ingredientDao.create(ingredient);
    } catch (IngredientDaoException ingredientDaoException) {
      throw new IngredientServiceException(ingredientDaoException.getMessage());
    }
  }

  @Transactional
  public Ingredient update(Ingredient ingredient) throws IngredientServiceException {
    try {
      return this.ingredientDao.update(ingredient);
    } catch (IngredientDaoException ingredientDaoException) {
      throw new IngredientServiceException(ingredientDaoException.getMessage());
    }
  }

  @Transactional
  public Ingredient delete(Ingredient ingredient) throws IngredientServiceException {
    try {
      return this.ingredientDao.delete(ingredient);
    } catch (IngredientDaoException ingredientDaoException) {
      throw new IngredientServiceException(ingredientDaoException.getMessage());
    }
  }

  @Transactional
  public Ingredient deleteById(long ingredient) throws IngredientServiceException {
    try {
      return this.ingredientDao.deleteById(ingredient);
    } catch (IngredientDaoException ingredientDaoException) {
      throw new IngredientServiceException(ingredientDaoException.getMessage());
    }
  }

}
