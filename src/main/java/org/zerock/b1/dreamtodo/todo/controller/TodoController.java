package org.zerock.b1.dreamtodo.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class TodoController {

    @GetMapping("details/{id}")
    public String get(Long id) {

        log.info("test");

        return "test";
    }
}
