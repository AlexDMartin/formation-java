package com.excilys.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "RecipeIngredient")
@Table(name = "RecipeIngredient")
public class RecipeIngredient {
  private Long id;
  private Ingredient ingredient;
  private Long quantity;
  private String unit;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @OneToOne
  @JoinColumn(name = "FK_INGREDIENT")
  public Ingredient getIngredient() {
    return ingredient;
  }

  public void setIngredient(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  @Column(name = "QUANTITY")
  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  @Column(name = "UNIT")
  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Override
  public String toString() {
    return "RecipeIngredient [id=" + id + ", ingredient=" + ingredient + ", quantity=" + quantity
        + ", unit=" + unit + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
    result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
    result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
    RecipeIngredient other = (RecipeIngredient) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (ingredient == null) {
      if (other.ingredient != null)
        return false;
    } else if (!ingredient.equals(other.ingredient))
      return false;
    if (quantity == null) {
      if (other.quantity != null)
        return false;
    } else if (!quantity.equals(other.quantity))
      return false;
    if (unit == null) {
      if (other.unit != null)
        return false;
    } else if (!unit.equals(other.unit))
      return false;
    return true;
  }
  
}
