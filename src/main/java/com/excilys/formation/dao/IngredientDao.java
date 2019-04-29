package com.excilys.formation.dao;

import com.excilys.formation.exception.IngredientDaoException;
import com.excilys.formation.model.Ingredient;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class IngredientDao {

  private EntityManager entityManager;


  private IngredientDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }


  public Optional<Ingredient> getById(Long id) throws IngredientDaoException {
    try {
      return Optional.of(entityManager.find(Ingredient.class, id));
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new IngredientDaoException("Could not retrieve the Ingredient with id :" + id);
    }
  }

  public List<Ingredient> getAll() throws IngredientDaoException {
    try {
      Query query = this.entityManager.createQuery("FROM Ingredient");
      return query.getResultList();
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new IngredientDaoException("Could not retrieve the ingredients");
    }
  }

  public Ingredient create(Ingredient ingredient) throws IngredientDaoException {
    try {
      this.entityManager.persist(ingredient);
      return ingredient;
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new IngredientDaoException("Could not create the ingredient " + ingredient);
    }
  }

  public Ingredient update(Ingredient ingredient) throws IngredientDaoException {
    try {
      this.entityManager.merge(ingredient);
      this.entityManager.flush();
      return ingredient;
    } catch (PersistenceException | IllegalArgumentException exception) {
      throw new IngredientDaoException("Could not update the ingredient " + ingredient);
    }
  }

  public Ingredient delete(Ingredient ingredient) throws IngredientDaoException {
    try {

      Optional<Ingredient> ingredientBuffer = this.getById(ingredient.getId());

      if (ingredientBuffer.isPresent()) {
        this.entityManager.remove(ingredientBuffer.get());
      }

      return ingredientBuffer.get();
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new IngredientDaoException("Could not delete the ingredient " + ingredient);
    }
  }

  public Ingredient deleteById(Long id) throws IngredientDaoException {
    try {
      Optional<Ingredient> ingredient = this.getById(id);

      if (ingredient.isPresent()) {
        this.entityManager.remove(ingredient.get());
        return ingredient.get();
      }

      return null;
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new IngredientDaoException("Could not delete the ingredient with id : " + id);
    }
  }

}
