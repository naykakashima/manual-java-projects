package com.naykakashima.minitodoapi.application.impl;

import com.naykakashima.minitodoapi.application.TodoService;
import com.naykakashima.minitodoapi.domain.Todo;
import com.naykakashima.minitodoapi.infrastructure.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo create(String name, String description) {
        Todo todo = new Todo(name, description); // id will be set by DB
        return todoRepository.save(todo);
    }

    @Override
    public Todo markDone(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setDone(true);
        return todoRepository.save(todo);
    }

    @Override
    public void delete(long id) {
        todoRepository.deleteById(id);
    }
}
