package com.foliaco.demo_jenkins.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.foliaco.demo_jenkins.model.Todo;
import com.foliaco.demo_jenkins.service.TodoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private RestTemplate restTemplate;

    private final String API_URL = "https://jsonplaceholder.typicode.com/todos";

    @Override
    public List<Todo> getAllTodos() {
        log.info("Getting all todos");
        Todo[] todos = restTemplate.getForObject(API_URL, Todo[].class);
        return Arrays.asList(todos);

    }

    @Override
    public Todo findById(Long id) {
        log.info("Find todo with id {}", id);
        Todo todo = restTemplate.getForObject(API_URL + "/" + id , Todo.class);
        return todo;
    }
    
}
