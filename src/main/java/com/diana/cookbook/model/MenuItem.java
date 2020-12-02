package com.diana.cookbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem implements AbstractIdentifiable{
	@Id
	@NonNull
	private Long id;
	
	@OneToMany 
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private Meal meal;
	
	@Column(name = "meal_time")
	private String mealTime;
	
}
