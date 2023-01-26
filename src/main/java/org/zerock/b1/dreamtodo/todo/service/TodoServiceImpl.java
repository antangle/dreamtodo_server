package org.zerock.b1.dreamtodo.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.b1.dreamtodo.reply.domain.Reply;
import org.zerock.b1.dreamtodo.reply.repository.ReplyRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.repository.TodoRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    private final ReplyRepository replyRepository;

    private final ModelMapper modelMapper;

    @Override
    public TodoDTO getOne(Long id) {

        log.info("Todo getOne, tid: " + id);

        List<Reply> replyList = replyRepository.findAll();

        Todo todo = todoRepository.findById(id).get();

        TodoDTO todoDTO = TodoDTO.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .contents(todo.getContents())
                .mName(todo.getMember().getName())
                .replyList(replyList)
                .createDate(todo.getCreateDate())
                .updateDate(todo.getUpdateDate())
                .build();

        return todoDTO;

    }
}
