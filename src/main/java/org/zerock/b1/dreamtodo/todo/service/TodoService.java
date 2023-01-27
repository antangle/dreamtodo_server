package org.zerock.b1.dreamtodo.todo.service;

import org.zerock.b1.dreamtodo.common.dto.PageResultDTO;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.dto.TodoAddDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoUpdateDTO;

public interface TodoService {

    PageResultDTO<Todo> getListBySelectedDate(String date);

    TodoDTO getOne(Long id);

    TodoDTO add(TodoAddDTO dto);

    TodoDTO modify(TodoUpdateDTO dto);

    void remove(Long id);
}
