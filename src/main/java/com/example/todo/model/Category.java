package com.example.todo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@Column
	String seasonalClothes;
	
	@Column
	String seasonalShoes;
	
	@Column
	String seasonalCap;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product>product;

	
	

}
