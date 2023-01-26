package org.zerock.b1.dreamtodo.todo.service;

import org.zerock.b1.dreamtodo.common.dto.PageResultDTO;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;

public interface TodoService {

    PageResultDTO<Todo> getListBySelectedDate(String date);

    TodoDTO getOne(Long id);
}
