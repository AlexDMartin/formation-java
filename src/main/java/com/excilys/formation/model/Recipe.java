package com.excilys.formation.model;

import java.util.HashSet;
import java.util.Set;

public class Recipe {
  private Long id;
  private String name;
  private String picture;
  private String description;
  private Set<RecipeIngredient> ingredients = new HashSet<>();
  private Set<String> instructions = new HashSet<>();

  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<RecipeIngredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Set<RecipeIngredient> ingredients) {
    this.ingredients = ingredients;
  }

  public Set<String> getInstructions() {
    return instructions;
  }

  public void setInstructions(Set<String> instructions) {
    this.instructions = instructions;
  }

  @Override
  public String toString() {
    return "Recipe [id=" + id + ", name=" + name + ", picture=" + picture + ", description="
        + description + ", ingredients=" + ingredients + ", instructions=" + instructions + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
    result = prime * result + ((instructions == null) ? 0 : instructions.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((picture == null) ? 0 : picture.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Recipe other = (Recipe) obj;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (ingredients == null) {
      if (other.ingredients != null)
        return false;
    } else if (!ingredients.equals(other.ingredients))
      return false;
    if (instructions == null) {
      if (other.instructions != null)
        return false;
    } else if (!instructions.equals(other.instructions))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (picture == null) {
      if (other.picture != null)
        return false;
    } else if (!picture.equals(other.picture))
      return false;
    return true;
  }
  
}
