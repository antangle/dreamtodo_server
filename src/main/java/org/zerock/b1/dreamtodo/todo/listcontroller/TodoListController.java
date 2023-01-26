package org.zerock.b1.dreamtodo.todo.listcontroller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.b1.dreamtodo.todo.dto.TodoAddDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoUpdateDTO;
import org.zerock.b1.dreamtodo.todo.service.TodoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/list/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class TodoListController {

    private final TodoService todoService;

    @GetMapping("details/{id}")
    public TodoDTO get(@PathVariable Long id) {

        log.info("/api/detail/" + id + ".....");

        return todoService.getOne(id);
    }

    @PutMapping("update_detail")
    public TodoDTO modify(@RequestBody TodoUpdateDTO dto) {

        log.info("Todo Modify.........");

        return todoService.modify(dto);
    }

    @DeleteMapping("delete_detail/{id}")
    public void remove(@PathVariable Long id) {

        log.info("Todo Remove.....");

        todoService.remove(id);
    }


    @PostMapping("add")
    public void add(@Valid @RequestBody TodoAddDTO dto) {

        log.info("/api/add......");
        log.info("DTO: " + dto);

        todoService.add(dto);

    }


}
