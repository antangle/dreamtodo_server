package org.zerock.b1.dreamtodo.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.b1.dreamtodo.common.dto.PageReqDTO;
import org.zerock.b1.dreamtodo.common.dto.PageResultDTO;
import org.zerock.b1.dreamtodo.reply.domain.Reply;
import org.zerock.b1.dreamtodo.reply.repository.ReplyRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.repository.TodoRepository;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    private final ReplyRepository replyRepository;

    private final ModelMapper modelMapper;

    @Override
    public PageResultDTO<Todo> getListBySelectedDate(String date) {

        PageReqDTO pageReqDTO = new PageReqDTO();

        Pageable pageable = pageReqDTO.getPageable(Sort.by("id").descending());

        Page<Todo> result = todoRepository.searchWithDate(pageable, date);

        //List<Object[]>
        List<Todo> list = result.getContent().stream().collect(Collectors.toList());

        PageResultDTO<Todo> pageResult =
                new PageResultDTO<>(list,pageable, result.getTotalElements(), result.getTotalPages() );

        return pageResult;

    }

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
