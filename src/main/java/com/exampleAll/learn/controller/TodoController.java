package com.exampleAll.learn.controller;



import com.exampleAll.learn.model.ToDo;
import com.exampleAll.learn.services.TodoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //The function receives a GET request, processes it and gives back a list of ToDo as a response.
    @GetMapping
    public ResponseEntity<List<ToDo>> getAllTodos() {
        List<ToDo> todos = todoService.getTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
    //The function receives a GET request with id in the url path, processes it and returns a ToDo with the specified Id
    @GetMapping({"/{todoId}"})
    public ResponseEntity<ToDo> getTodo(@PathVariable Long todoId) {
        return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new ToDo and saves it to the database and returns a resource link to the created todo.
    @PostMapping
    public ResponseEntity<ToDo> saveTodo(@RequestBody ToDo todo) {
        ToDo todo1 = todoService.insert(todo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/api/v1/todo/" + todo1.getId().toString());
        return new ResponseEntity<>(todo1, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the ToDo with the specified Id and returns the updated ToDo
    @PutMapping({"/{todoId}"})
    public ResponseEntity<ToDo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody ToDo todo) {
        todoService.updateTodo(todoId, todo);
        return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the ToDo with the specified Id.
    @DeleteMapping({"/{todoId}"})
    public ResponseEntity<ToDo> deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
