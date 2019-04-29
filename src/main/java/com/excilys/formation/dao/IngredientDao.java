package com.excilys.formation.dao;

import com.excilys.formation.model.Ingredient;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class IngredientDao {

  private EntityManager entityManager;
  
  
  private IngredientDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  
  public Optional<Ingredient> getById(Long id) {
    return Optional.of(entityManager.find(Ingredient.class, id));
  }

  public List<Ingredient> getAll() {
    Query query = this.entityManager.createQuery("FROM Ingredient");
    return query.getResultList();
  }

  public Ingredient create(Ingredient ingredient) {
    this.entityManager.persist(ingredient);
    return ingredient;
  }

  public Ingredient update(Ingredient ingredient) {
    this.entityManager.merge(ingredient);
    this.entityManager.flush();
    return ingredient;
  }

  public Ingredient delete(Ingredient ingredient) {
   Optional<Ingredient> ingredientBuffer = this.getById(ingredient.getId());
   
   if(ingredientBuffer.isPresent()) {     
     this.entityManager.remove(ingredientBuffer.get());
   }
   
   return ingredientBuffer.get();
  }
  
  public Ingredient deleteById(Long id) {
    Optional<Ingredient> ingredient = this.getById(id);
    
    if (ingredient.isPresent()) {
      this.entityManager.remove(ingredient.get());
      return ingredient.get();
    }
    
    return null;
  }

}
