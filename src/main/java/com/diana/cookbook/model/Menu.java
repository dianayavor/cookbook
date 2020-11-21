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
@Table(name = "menu")
public class Menu implements AbstractIdentifiable {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@ManyToMany
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private List<Meal> meals;
	
	public Menu() {}

	public Menu(Long id, List<Meal> meals) {
		super();
		this.id = id;
		this.meals = meals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((meals == null) ? 0 : meals.hashCode());
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
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (meals == null) {
			if (other.meals != null)
				return false;
		} else if (!meals.equals(other.meals))
			return false;
		return true;
	}
	
	
}
