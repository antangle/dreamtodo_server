package org.zerock.b1.dreamtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b1.dreamtodo.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
