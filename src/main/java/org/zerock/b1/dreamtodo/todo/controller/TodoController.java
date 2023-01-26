package org.zerock.b1.dreamtodo.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.service.TodoService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class TodoController {

    private final TodoService todoService;

    @GetMapping("details/{id}")
    public TodoDTO get(@PathVariable Long id) {

        log.info(id);

        log.info("/api/detail/" + id + ".....");

        return todoService.getOne(id);
    }
}
