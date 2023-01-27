package org.zerock.b1.todo.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.zerock.b1.dreamtodo.member.domain.Member;
import org.zerock.b1.dreamtodo.member.repository.MemberRepository;
import org.zerock.b1.dreamtodo.reply.repository.ReplyRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.repository.TodoRepository;
import org.zerock.b1.dreamtodo.todo.service.TodoService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TodoService todoService;

    @Test
    public void testInserts() {

        log.info("Todo testInerts..........");

        Long mid = 1L;

        try {
            Member member = memberRepository.findById(mid).get();

            Todo todo = Todo.builder()
                    .title("lshTitle3")
                    .contents("lshContents3")
                    .member(member)
                    .createDate(LocalDate.now())
                    .updateDate(LocalDate.now())
                    .build();

            log.info(todoRepository.save(todo));
        } catch (NoSuchElementException e) {
            log.info("No Member mid");
        }
    }

    @Test
    public void testGetOne() {

        log.info("Todo testGetOne..........");

        Long tid = 1L;

        try{
            log.info("result: " + todoService.getOne(tid));
        } catch (NoSuchElementException e) {
            log.info("No Todo tid");
        }
    }

    @Test
    public void testGetList() {

        log.info("Todo testGetList..........");

        //log.info("result: " + todoRepository.findAll());

        List<Todo> list = todoRepository.findAll();

        log.info(list.get(1));


    }

    @Transactional
    @Test
    public void testReplyRemove() {

        log.info("Todo testReplyRemove........");


        replyRepository.removeReply(2L);
    }


}
