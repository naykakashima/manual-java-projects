package com.naykakashima.minitodoapi.presentation;

import com.naykakashima.minitodoapi.application.TodoService;
import com.naykakashima.minitodoapi.domain.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/getAllTodos")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @PostMapping("/createTodo")
    public Todo create(@RequestBody Todo todo) {
        return todoService.create(todo.getName(), todo.getDescription());
    }

}
