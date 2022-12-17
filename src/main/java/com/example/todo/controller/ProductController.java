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

import com.example.todo.model.Product;
import com.example.todo.service.ProductService;
import com.example.todo.util.ResponseWrapper;
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/Products")
	public ResponseEntity<?>getAllProducts(){
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setSubject("All Product List");
	    wrapper.setBody( productService.getAll());
	    return new ResponseEntity<>(wrapper,HttpStatus.OK);		
	}
	
	
	 @PostMapping("/Products")
	   public ResponseEntity<?> addProduct(@RequestBody Product product ) {
		 ResponseWrapper wrapper=new  ResponseWrapper();
		  wrapper.setSubject("Product Resource Created ");
		  wrapper.setBody(productService.add(product)) ;
		  return new ResponseEntity<>(wrapper,HttpStatus.OK);
		 
	}
	 
	 
	 
	 @DeleteMapping("/Products/{id}")
	 public ResponseEntity<?> deleteProduct( @PathVariable Integer id) {
		 String message = productService.delete(id);
		  ResponseWrapper wrapper=new  ResponseWrapper();
		  if(message==null)
		  {		  
			  wrapper.setSubject("Product Not Found");
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
		 	 
	 
	 @GetMapping("/Products/{id}")
	  public ResponseEntity<?> findProduct(@PathVariable  Integer id) {
		 Product foundProduct = productService.find(id);
		  ResponseWrapper wrapper=new  ResponseWrapper();	  
		  if(foundProduct == null)
		  {
			  wrapper.setSubject("Product Not Found");
			  wrapper.setBody(null);
			  return new  ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
		  }
		  else {
			  
				  wrapper.setSubject("Product Found: " + id);
				  wrapper.setBody(foundProduct);
			  return new ResponseEntity<>(wrapper,HttpStatus.OK) ;
			   
		  }
		     
		 
	  }	
	 
	 
	 
	 
	 @PutMapping("/Products/{id}")
	  public ResponseEntity<?>updateProduct (@PathVariable Integer id,@RequestBody  Product product ) {
		  
		  Product  updateProduct = productService.update(id,product);
		  ResponseWrapper wrapper=new  ResponseWrapper();	
		  
		  if(updateProduct == null)
		  {
			  
			  wrapper.setSubject("Product Not Found");
			  wrapper.setBody(null);
			  
			  return new  ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
		  }
		  else {
			  
			  wrapper.setSubject("Category Found: " + id);
			  wrapper.setBody(updateProduct);
			  return new ResponseEntity<>(wrapper,HttpStatus.OK) ;
			   
		  }
		     
	  }  
	  
	 
	 
	 
	 
	 
	 

	}
	
	
	
	


