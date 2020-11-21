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

@Entity
@Table(name = "dishes")
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
	
	public Dishes() {}

	public Dishes(Long id, String name, Double proteins, Double fat, Double carbohydrates, String photo,
			Boolean isGlobal, User owner) {
		super();
		this.id = id;
		this.name = name;
		this.proteins = proteins;
		this.fat = fat;
		this.carbohydrates = carbohydrates;
		this.photo = photo;
		this.isGlobal = isGlobal;
		this.owner = owner;
	}

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

	public Double getProteins() {
		return proteins;
	}

	public void setProteins(Double proteins) {
		this.proteins = proteins;
	}

	public Double getFat() {
		return fat;
	}

	public void setFat(Double fat) {
		this.fat = fat;
	}

	public Double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(Double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Boolean getIsGlobal() {
		return isGlobal;
	}

	public void setIsGlobal(Boolean isGlobal) {
		this.isGlobal = isGlobal;
	}

	public User getUserId() {
		return owner;
	}

	public void setUserId(User owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carbohydrates == null) ? 0 : carbohydrates.hashCode());
		result = prime * result + ((fat == null) ? 0 : fat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isGlobal == null) ? 0 : isGlobal.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((proteins == null) ? 0 : proteins.hashCode());
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
		Dishes other = (Dishes) obj;
		if (carbohydrates == null) {
			if (other.carbohydrates != null)
				return false;
		} else if (!carbohydrates.equals(other.carbohydrates))
			return false;
		if (fat == null) {
			if (other.fat != null)
				return false;
		} else if (!fat.equals(other.fat))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isGlobal == null) {
			if (other.isGlobal != null)
				return false;
		} else if (!isGlobal.equals(other.isGlobal))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (proteins == null) {
			if (other.proteins != null)
				return false;
		} else if (!proteins.equals(other.proteins))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
	
}
