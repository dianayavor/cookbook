package com.diana.cookbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "menu_item")
public class MenuItem implements AbstractIdentifiable{
	@Id
	@NonNull
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private Meal meal;
	
	@Column(name = "meal_time")
	private String mealTime;
	
	public MenuItem() {	}

	public MenuItem(Long id, Meal meal, String mealTime) {
		super();
		this.id = id;
		this.meal = meal;
		this.mealTime = mealTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public String getMealTime() {
		return mealTime;
	}

	public void setMealTime(String mealTime) {
		this.mealTime = mealTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((meal == null) ? 0 : meal.hashCode());
		result = prime * result + ((mealTime == null) ? 0 : mealTime.hashCode());
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
		MenuItem other = (MenuItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (meal == null) {
			if (other.meal != null)
				return false;
		} else if (!meal.equals(other.meal))
			return false;
		if (mealTime == null) {
			if (other.mealTime != null)
				return false;
		} else if (!mealTime.equals(other.mealTime))
			return false;
		return true;
	}
	
	
}
