package org.zerock.b1.dreamtodo.reply.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reply/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class ReplyController {


    @PostMapping("add")
    public void add(@Valid @RequestBody int a) {

    }

    @PutMapping("update_reply")
    public void modify() {

    }

    @DeleteMapping("delete_reply/{id}")
    public void remove(@PathVariable Long id) {

    }
}
