package com.excilys.formation.dao;

import com.excilys.formation.exception.RecipeDaoException;
import com.excilys.formation.model.Recipe;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.stereotype.Component;


@Component
public class RecipeDao {

  private EntityManager entityManager;
  
  private RecipeDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }
  
  public Optional<Recipe> getById(long id) throws RecipeDaoException {
    try {      
      return Optional.of(entityManager.find(Recipe.class, id));
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new RecipeDaoException("Could not retrieve the recipe with id : " + id);
    }
  }

  public List<Recipe> getAll() throws RecipeDaoException {
    try {      
      Query query = this.entityManager.createQuery("FROM Recipe");
      return query.getResultList();
    }
    catch (IllegalArgumentException illegalArgumentException) {
      throw new RecipeDaoException("Could not retrieve the recipes");
    }
  }

  public Recipe create(Recipe recipe) throws RecipeDaoException {
    try {      
      this.entityManager.persist(recipe);
      return recipe;
    }
    catch (IllegalArgumentException illegalArgumentException) {
      throw new RecipeDaoException("Could not create the new recipe : " + recipe);
    }
  }

  public Recipe update(Recipe recipe) throws RecipeDaoException {
    try {      
      this.entityManager.merge(recipe);
      this.entityManager.flush();
      return recipe;
    }
    catch (PersistenceException|IllegalArgumentException exception){
      throw new RecipeDaoException("Could not update the new recipe : " + recipe);
    }
  }

  public Recipe delete(Recipe recipe) throws RecipeDaoException {
    try {      
      Optional<Recipe> recipeBuffer = this.getById(recipe.getId());
      
      if(recipeBuffer.isPresent()) {     
        this.entityManager.remove(recipeBuffer.get());
      }
      
      return recipeBuffer.get();
    }
    catch (IllegalArgumentException illegalArgumentException) {
      throw new RecipeDaoException("Could not delete the recipe " + recipe);
    }
  }
  
  public Recipe deleteById(long id) throws RecipeDaoException {
    try {      
      Optional<Recipe> recipe = this.getById(id);
      
      if (recipe.isPresent()) {
        this.entityManager.remove(recipe.get());
      }
      
      return recipe.get();
    }
    catch (IllegalArgumentException illegalArgumentException) {
      throw new RecipeDaoException("Could not delete the recipe with id " + id);
    }
  }

}
