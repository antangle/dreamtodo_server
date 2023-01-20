package org.zerock.b1.todo.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.b1.todo.domain.Todo;
import org.zerock.b1.todo.dto.TodoListDTO;
import org.zerock.b1.todo.dto.TodoSearchDTO;

public interface TodoSearch {

    Page<Todo> searchList(Pageable pageable, String keyword);

    Page<Object[]> searchListWithCount(Pageable pageable);

    Page<TodoListDTO> searchListWithCount2(Pageable pageable, TodoSearchDTO searchDTO);

}
