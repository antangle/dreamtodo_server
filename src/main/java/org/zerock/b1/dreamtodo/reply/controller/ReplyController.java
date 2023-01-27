package org.zerock.b1.dreamtodo.reply.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.b1.dreamtodo.reply.dto.ReplyAddDTO;
import org.zerock.b1.dreamtodo.reply.dto.ReplyUpdateDTO;
import org.zerock.b1.dreamtodo.reply.service.ReplyService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reply/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("add")
    public void add(@Valid @RequestBody ReplyAddDTO dto) {

        log.info("Reply Add.....");

        replyService.add(dto);
    }

    @PutMapping("update_reply")
    public void modify(@Valid @RequestBody ReplyUpdateDTO dto) {

        log.info("Reply Modify.....");

        replyService.modify(dto);
    }

    @DeleteMapping("delete_reply/{id}")
    public void remove(@PathVariable Long id) {

        log.info("Reply Remove......");

        replyService.remove(id);
    }
}
