package com.naykakashima.minitodoapi.application;

import com.naykakashima.minitodoapi.domain.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();
    Todo create(String name, String description);
    Todo markDone(long id);
    void delete(long id);
}
