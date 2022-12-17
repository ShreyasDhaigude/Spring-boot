package com.example.todo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.todo.model.User;
@Repository
public interface UserRepository extends
CrudRepository<User, Integer>{

	@RestResource(exported = false)
	<S extends User> S save(S entity);
	
	Optional<User> findByEmail(String email);
	@RestResource(exported = false)
	Optional<User> findByEmail(String email);
	}

	

