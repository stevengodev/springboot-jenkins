package com.foliaco.demo_jenkins.service;

import java.util.List;

import com.foliaco.demo_jenkins.model.Todo;

public interface TodoService {

    List<Todo> getAllTodos();
    Todo findById(Long id);
    
}
