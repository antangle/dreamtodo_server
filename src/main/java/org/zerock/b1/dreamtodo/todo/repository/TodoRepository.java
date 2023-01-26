package org.zerock.b1.dreamtodo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoUpdateDTO;


public interface TodoRepository extends JpaRepository<Todo, Long> {

/*
    @Query(value = "delete from Reply r " +
            "where r.todo.id = :tid")
    void removeReply(@Param("tid") Long tid);

 */

}
