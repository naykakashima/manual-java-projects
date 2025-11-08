package com.naykakashima.minitodoapi.infrastructure.repository;

import com.naykakashima.minitodoapi.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
