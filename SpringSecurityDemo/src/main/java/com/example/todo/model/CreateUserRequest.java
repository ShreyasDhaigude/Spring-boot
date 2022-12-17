package com.example.todo.model;

import java.util.List;

import lombok.Data;
@Data
public class CreateUserRequest{
	
	private String name;
	private String email;
	private String password;
	private List<String> roles;
	
	
}







