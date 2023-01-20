package org.zerock.b1.todo.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zerock.b1.common.annotations.JWTAuth;
import org.zerock.b1.common.dto.PageReqDTO;
import org.zerock.b1.common.dto.PageResultDTO;
import org.zerock.b1.todo.dto.TodoAddDTO;
import org.zerock.b1.todo.dto.TodoDTO;
import org.zerock.b1.todo.dto.TodoListDTO;
import org.zerock.b1.todo.dto.TodoSearchDTO;
import org.zerock.b1.todo.service.TodoService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class TodoController {

    private final TodoService todoService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TodoDTO add(@Valid @RequestBody TodoAddDTO dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("has error");

            throw new RuntimeException("binding exception");
        }
        log.info(dto);

        return todoService.add(dto);

    }

    @GetMapping("list")
    public PageResultDTO<TodoListDTO> getList(PageReqDTO pageReqDTO) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return todoService.getList(pageReqDTO);
    }

    @JWTAuth
    @GetMapping("{id}")
    public TodoDTO get(@PathVariable Long id) {

        log.info(todoService.getClass().getName());

        return todoService.getOne(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

        log.info("--------------------todo delete.............");
        log.info(id);

        todoService.remove(id);
    }
}












