package org.zerock.b1.dreamtodo.todo.service;

import org.zerock.b1.dreamtodo.todo.dto.TodoAddDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoUpdateDTO;

import java.util.List;

public interface TodoService {

    TodoDTO getOne(Long id);

    TodoDTO add(TodoAddDTO dto);

    TodoDTO modify(TodoUpdateDTO dto);

    void remove(Long id);
}
