package org.zerock.b1.dreamtodo.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.zerock.b1.dreamtodo.common.dto.PageResultDTO;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.service.TodoService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class TodoController {

    private final TodoService todoService;



    @PostMapping("todo/date")
    public void getDate(@RequestBody String date) {

        log.info(date);
        log.info(date.substring(0, 10));
        getListByDate(date.substring(0, 10));

    }

    @GetMapping("/todo/search")
    public PageResultDTO<Todo> getListByDate(@RequestParam String date) {

        log.info("------getListByDate------");
        log.info(date);

        return todoService.getListBySelectedDate(date);
    }
}
