package org.zerock.b1.reply.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b1.dreamtodo.member.domain.Member;
import org.zerock.b1.dreamtodo.member.repository.MemberRepository;
import org.zerock.b1.dreamtodo.reply.domain.Reply;
import org.zerock.b1.dreamtodo.reply.repository.ReplyRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.repository.TodoRepository;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testInserts() {

        log.info("Reply testInserts.........");

        Long tid = 1L;

        Todo todo = todoRepository.findById(tid).get();

        Member member = memberRepository.findById(todo.getMember().getId()).get();

        Reply reply = Reply.builder()
                .contents("reply contents3")
                .todo(todo)
                .member(member)
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .build();

        log.info(replyRepository.save(reply));

    }
}
