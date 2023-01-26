package org.zerock.b1.dreamtodo.reply.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.b1.dreamtodo.reply.domain.Reply;
import org.zerock.b1.dreamtodo.reply.dto.ReplyAddDTO;
import org.zerock.b1.dreamtodo.reply.dto.ReplyDTO;
import org.zerock.b1.dreamtodo.reply.dto.ReplyUpdateDTO;
import org.zerock.b1.dreamtodo.reply.repository.ReplyRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.repository.TodoRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyRepository replyRepository;

    private final TodoRepository todoRepository;

    private final ModelMapper modelMapper;

    @Override
    public ReplyDTO add(ReplyAddDTO dto) {

        log.info("Reply Add......");

        Todo todo = todoRepository.findById(dto.getTid()).get();

        Reply reply = Reply.builder()
                .contents(dto.getContents())
                .todo(todo)
                .member(dto.getMember())
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .build();

        replyRepository.save(reply);

        return modelMapper.map(reply, ReplyDTO.class);
    }

    @Override
    public ReplyDTO modify(ReplyUpdateDTO dto) {

        log.info("Reply modify.......");


        return null;
    }
}
