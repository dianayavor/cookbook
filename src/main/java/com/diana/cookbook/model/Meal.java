package com.diana.cookbook.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "meal")
public class Meal implements AbstractIdentifiable {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long owner;
	
	@NotNull
	@ManyToMany
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private List<Dishes> dishes;
	
	public Meal() {}

	public Meal(Long owner, List<Dishes> dishes) {
		super();
		this.owner = owner;
		this.dishes = dishes;
	}

	public Long getMealId() {
		return owner;
	}

	public void setMealId(Long mealId) {
		this.owner = mealId;
	}

	public List<Dishes> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dishes> dishes) {
		this.dishes = dishes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishes == null) ? 0 : dishes.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		Meal other = (Meal) obj;
		if (dishes == null) {
			if (other.dishes != null)
				return false;
		} else if (!dishes.equals(other.dishes))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
	
}
