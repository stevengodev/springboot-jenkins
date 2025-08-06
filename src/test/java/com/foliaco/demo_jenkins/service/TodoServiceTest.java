package com.foliaco.demo_jenkins.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.foliaco.demo_jenkins.model.Todo;
import com.foliaco.demo_jenkins.service.impl.TodoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private TodoServiceImpl todoService;

    private final String API_URL = "https://jsonplaceholder.typicode.com/todos";

    @Test
    void whenGetAllTodos_ThenReturnTodoList(){

        when( restTemplate.getForObject(API_URL, Todo[].class) ).thenReturn(
            new Todo[]{
                new Todo(1L, 1L, "My first todo", true),
                new Todo(2L, 1L, "My second todo", true)
        });

        List<Todo> todos = todoService.getAllTodos();

        assertTrue(todos.size() == 2);
        assertNotNull(todos);

    }

    @Test
    void givenTodoId_whenFindById_thenReturnTodo(){

        Long id = 1L;

        when(restTemplate.getForObject(API_URL + "/" + id , Todo.class)).thenReturn(
            new Todo(1L, 1L, "My first todo", true)
        );

        Todo todo = todoService.findById(id);

        assertNotNull(todo);
        assertEquals("My first todo", todo.getTitle());

    }

}
