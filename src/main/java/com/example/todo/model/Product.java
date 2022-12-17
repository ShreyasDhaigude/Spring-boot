package com.example.todo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@Column
	String clothes;
	@Column
	String shoes;
	@Column
	String cap;
	
	
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	

	


}
