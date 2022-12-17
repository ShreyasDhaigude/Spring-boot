package com.example.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.model.Product;

@Repository
public interface ProductRepository 

  extends CrudRepository<Product, Integer> {
	

}
