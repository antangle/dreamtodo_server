package org.zerock.b1.todo;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b1.dreamtodo.file.repository.TFileRepository;
import org.zerock.b1.dreamtodo.member.repository.MemberRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.repository.TodoRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TFileRepository tFileRepository;

    @Test
    public void insertTodos() {

        IntStream.rangeClosed(1,100).forEach((i) -> {

            Todo todo = Todo.builder()
                    .title("Title" + i)
                    .contents("contents" + i)
                    .regDate(LocalDate.now().plusDays(i))
                    .createDate(LocalDate.now())
                    .updateDate(LocalDate.now())
                    .build();

            log.info(todoRepository.save(todo));

        });//end loop
    }
}
