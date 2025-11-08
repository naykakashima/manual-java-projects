package com.naykakashima.minitodoapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ← JPA auto-generates the ID
    private Long id;

    private String name;
    private String description;
    private boolean done;

    // Default constructor required by JPA
    public Todo() {}

    // Constructor for creating new todos (no id!)
    public Todo(String name, String description) {
        this.name = name;
        this.description = description;
        this.done = false;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) && Objects.equals(name, todo.name) && Objects.equals(description, todo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
