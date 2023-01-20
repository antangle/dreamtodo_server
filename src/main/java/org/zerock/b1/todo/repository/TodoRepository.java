package org.zerock.b1.todo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.b1.todo.domain.Todo;
import org.zerock.b1.todo.repository.search.TodoSearch;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {



    @Query(value = "select todo, count(reply) " +
            " from Todo todo left join  Reply reply on reply.todo = todo" +
            " group by todo"
            ,
            countQuery = "select count(todo) from Todo todo")
    Page<Object[]> listWithCount(Pageable pageable);
}
