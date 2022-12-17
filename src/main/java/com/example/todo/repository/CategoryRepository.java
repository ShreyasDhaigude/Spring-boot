package com.example.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.model.Category;

@Repository
public interface CategoryRepository

extends CrudRepository<Category, Integer>{
	
 
}
