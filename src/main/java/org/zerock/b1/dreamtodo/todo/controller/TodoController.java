package org.zerock.b1.dreamtodo.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class TodoController {


    @PostMapping("todo/date")
    public void getDate(@RequestBody String date) {

        log.info(date);
    }

    @GetMapping("details/{id}")
    public String get(Long id) {

        log.info("test");

        return "test";
    }
}
