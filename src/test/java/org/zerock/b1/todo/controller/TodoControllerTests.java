package org.zerock.b1.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b1.dreamtodo.member.domain.Member;
import org.zerock.b1.dreamtodo.member.repository.MemberRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.dto.TodoAddDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoUpdateDTO;
import org.zerock.b1.dreamtodo.todo.repository.TodoRepository;
import org.zerock.b1.dreamtodo.todo.service.TodoService;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoControllerTests {

    @Autowired
    private TodoService todoService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TodoRepository todoRepository;

    // /api/add Controller Test
    @Test
    public void addTest() {

        log.info("Todo addTest....");

        String title = "testAddTitle";
        String contents = "testAddContents";

        Long id = 1L;

        Member member = memberRepository.findById(id).get();

        TodoAddDTO todoAddDTO = TodoAddDTO.builder()
                .title(title)
                .contents(contents)
                .member(member)
                .build();

        todoService.add(todoAddDTO);

    }

    // Todo Update Test
    @Test
    public void updateTest() {

        log.info("Todo updateTest............");

        Long tid = 101L;

        TodoUpdateDTO dto = TodoUpdateDTO.builder()
                .id(tid)
                .title("uTT")
                .contents("uCC")
                .build();

        todoService.modify(dto);
    }

    // Todo Delete Test
    @Test
    public void deleteTest() {

        log.info("Todo deleteTest..........");

        todoService.remove(2L);

    }
}
