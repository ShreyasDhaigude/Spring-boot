package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Category;
import com.example.todo.model.Product;
import com.example.todo.service.CategoryService;
import com.example.todo.util.ResponseWrapper;
@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/Categorys")
	public ResponseEntity<?> getAllCategorys(){	
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setSubject("All Category List");
	    wrapper.setBody( categoryService.getAll());
	    return new ResponseEntity<>(wrapper,HttpStatus.OK);
	}

  @PostMapping("/Categorys")
   public ResponseEntity<?> addCategory(@RequestBody Category category ) {
	  ResponseWrapper wrapper=new  ResponseWrapper();
	  wrapper.setSubject("Category Resource Created ");
	  wrapper.setBody(categoryService.add(category)) ;
	  return new ResponseEntity<>(wrapper,HttpStatus.OK);
	  

}
  
  @DeleteMapping("/Categorys/{id}")
  public ResponseEntity<?> deleteCategory(@PathVariable  Integer id) {
	  String message = categoryService.delete(id);
	  ResponseWrapper wrapper=new  ResponseWrapper();
	  if(message==null)
	  {
		  
		  wrapper.setSubject("Category Not Found");
		  wrapper.setBody(null);
		  return new ResponseEntity<>(wrapper,HttpStatus.NOT_FOUND);
	  }
	  else
	  {
		  
		 wrapper.setSubject(message);
		 wrapper.setBody(null);
		 return new ResponseEntity<>(wrapper,HttpStatus.OK);
		  
	  }
	 
	  
	  
	  
	}
  
  @GetMapping("/Categorys/{id}")
  public ResponseEntity<?> findCategry(@PathVariable  Integer id) {
	  Category foundCategory = categoryService.find(id);
	  ResponseWrapper wrapper=new  ResponseWrapper();	  
	  if(foundCategory == null)
	  { 
		  wrapper.setSubject("Category Not Found");
		  wrapper.setBody(null);
		  return new  ResponseEntity<>("Category Not Found",HttpStatus.NOT_FOUND);
	  }
	  else {
		  wrapper.setSubject("Category Found: " + id);
		  wrapper.setBody(foundCategory);
		  return new ResponseEntity<>(wrapper,HttpStatus.OK) ;
		   
	  }
	     
	 
  }	

  @PutMapping("/Categorys/{id}")
  public ResponseEntity<?> updateCategory (@PathVariable Integer id,@RequestBody Category category ) {
	  
	  Category  updateCategory = categoryService.update(id,category);
	  ResponseWrapper wrapper=new  ResponseWrapper();	
	  
	  if(updateCategory == null)
	  { 
		  wrapper.setSubject("Category Not Found");
		  wrapper.setBody(null);
		  
		  return new  ResponseEntity<>(wrapper,HttpStatus.NOT_FOUND);
	  }
	  else {
		  wrapper.setSubject("Category Found: " + id);
		  wrapper.setBody(updateCategory);
		  return new ResponseEntity<>(wrapper,HttpStatus.OK) ;
		   
	  }
	     
  }
  
  
  
  @PostMapping("Categorys/{id}/Products")
  public ResponseEntity<?>addProduct(@PathVariable Integer id, @RequestBody Product product){
	  
	  ResponseWrapper wrapper= new ResponseWrapper();
	  
	  wrapper.setSubject("Product Added");
	  wrapper.setBody(this.categoryService.addProduct(id, product));
	  return new ResponseEntity<>(wrapper,HttpStatus.OK);
	  
  }
  
  
  @GetMapping("Categorys/{id}/Products")
  public ResponseEntity<?>getProduct(@PathVariable Integer id){
	  
	  ResponseWrapper wrapper= new ResponseWrapper();
	  
	  wrapper.setSubject("Products Created By Category :" +id);
	  wrapper.setBody(this.categoryService.getProducts(id));
	  return new ResponseEntity<>(wrapper,HttpStatus.OK);
	  
  }
  
  
  
  
  
  }
  


	  

