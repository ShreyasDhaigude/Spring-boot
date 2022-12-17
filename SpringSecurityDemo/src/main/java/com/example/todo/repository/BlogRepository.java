package com.example.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.todo.model.Blog;

public interface BlogRepository extends
CrudRepository<Blog, Integer>{


}
