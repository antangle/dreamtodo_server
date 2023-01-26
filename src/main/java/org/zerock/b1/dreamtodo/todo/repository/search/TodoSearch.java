package org.zerock.b1.dreamtodo.todo.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.b1.dreamtodo.todo.domain.Todo;

public interface TodoSearch {

    Page<Todo> searchWithDate(Pageable pageable, String date);

}
