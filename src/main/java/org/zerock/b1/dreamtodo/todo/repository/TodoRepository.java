package org.zerock.b1.dreamtodo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;


public interface TodoRepository extends JpaRepository<Todo, Long> {

}
