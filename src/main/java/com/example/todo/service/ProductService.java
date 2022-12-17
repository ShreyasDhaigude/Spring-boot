package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.Product;
import com.example.todo.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product>getAll(){
		return productRepository.findAll();
		
		
	}
	
	public Product add(Product product) {
		 
		 return productRepository.save(product);
		 
	 }
	
	
	public String delete(Integer id) {
		Product foundProduct =this.find(id);
		 if(foundProduct == null)
			  return null;
		 else {
			 
			 productRepository.deleteById(id);
			 return "Deleted";
			 
		 }
				
		
		
	}
	
	
	public Product find(Integer id) {
		
		return productRepository.findById(id).orElse(null);
	}
	
	

	public Product update(Integer id,Product product) {
		 Product foundProduct =this.find(id);
		 if(foundProduct == null)
		  return null;
		 else {
			 product.setId(id);
			 return productRepository.save(product);
			 
		 } 
	 }
	 

	

}