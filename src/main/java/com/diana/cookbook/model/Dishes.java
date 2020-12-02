package com.diana.cookbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dishes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dishes implements AbstractIdentifiable{
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "proteins")
	private Double proteins;
	
	@Column(name = "fat")
	private Double fat;
	
	@Column(name = "carbohydrates")
	private Double carbohydrates;
	
	@Nullable
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "isGloval")
	private Boolean isGlobal;
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private User owner;
	
}
