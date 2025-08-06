package com.foliaco.demo_jenkins.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foliaco.demo_jenkins.model.Todo;
import com.foliaco.demo_jenkins.service.TodoService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {
    
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        return ResponseEntity.ok( todoService.getAllTodos() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findTodoById(@PathVariable Long id) {
        return ResponseEntity.ok( todoService.findById(id) );
    }
    

}
