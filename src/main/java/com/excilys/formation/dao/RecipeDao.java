package com.excilys.formation.dao;

import com.excilys.formation.model.Recipe;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Component;


@Component
public class RecipeDao {

  private EntityManager entityManager;
  
  private RecipeDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }
  
  public Optional<Recipe> getById(long id) {
    return Optional.of(entityManager.find(Recipe.class, id));
  }

  public List<Recipe> getAll() {
    Query query = this.entityManager.createQuery("FROM Recipe");
    return query.getResultList();
  }

  public Recipe create(Recipe recipe) {
    this.entityManager.persist(recipe);
    return recipe;
  }

  public Recipe update(Recipe recipe) {
    this.entityManager.merge(recipe);
    this.entityManager.flush();
    return recipe;
  }

  public Recipe delete(Recipe recipe) {
    Optional<Recipe> recipeBuffer = this.getById(recipe.getId());
    
    if(recipeBuffer.isPresent()) {     
      this.entityManager.remove(recipeBuffer.get());
    }
    
    return recipeBuffer.get();
  }
  
  public Recipe deleteById(long id) {
    Optional<Recipe> recipe = this.getById(id);
    
    if (recipe.isPresent()) {
      this.entityManager.remove(recipe.get());
    }
    
    return recipe.get();
  }

}
