package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.Category;
import com.example.todo.model.Product;
import com.example.todo.repository.CategoryRepository;
import com.example.todo.repository.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	 private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Iterable<Category>getAll(){
		 
		 return categoryRepository.findAll();
	 }
	 
	 
	 public Category add(Category category) {
		 
		 return categoryRepository.save(category);
		 
	 }
	 
	 
	 public String delete(Integer id ) {
		 Category foundCategory =this.find(id);
		 if(foundCategory == null)
			  return null;
		 else {
			 
			 categoryRepository.deleteById(id);
			 return "Deleted";
			 
		 }
		
		 
	 }
	 
	 public Category find(Integer id) {
		 
		 return categoryRepository.findById(id).orElse(null);
	 }
	 
	 
	  
	 public Category update(Integer id,Category category) {
		 Category foundCategory =this.find(id);
		 if(foundCategory == null)
		  return null;
		 else {
			 category.setId(id);
			 return categoryRepository.save(category);
			 
		 }
		 
	 }
	 
	 
	 
      public Product addProduct(Integer categoryId,Product product ) {
		 
		 Category foundCategory =this.find(categoryId);
		 if(foundCategory == null)
			 return null;
		 
		 else {
			 product.setCategory(foundCategory);
			 return this.productRepository.save(product);
			 
			
			 	
		}
		     }
      
      
      public List<Product>getProducts(Integer id){
  	  
    	  Category foundCategory =this.find(id);
 		 if(foundCategory == null)
 			 return null;
 		 
 		 else {
 			 return foundCategory.getProduct();
 			 
 			
 			 	
 		}
    	  
    	  
    	  
      }
}
 