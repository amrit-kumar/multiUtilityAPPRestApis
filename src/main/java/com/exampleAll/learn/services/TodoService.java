package com.exampleAll.learn.services;


import com.exampleAll.learn.model.ToDo;

import java.util.List;

public interface TodoService {
    List<ToDo> getTodos();

    ToDo getTodoById(Long id);

    ToDo insert(ToDo todo);

    void updateTodo(Long id, ToDo todo);

    void deleteTodo(Long todoId);
}
