package org.zerock.b1.file.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b1.dreamtodo.file.domain.TFile;
import org.zerock.b1.dreamtodo.file.repository.TFileRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.repository.TodoRepository;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class FileRepositoryTests {


    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TFileRepository fileRepository;

    @Test
    public void testInsert() {

        log.info("File testInserts.......");

        Long tid = 1L;

        Todo todo = todoRepository.findById(tid).get();

        TFile file = TFile.builder()
                .uuid("uuid1")
                .todo(todo)
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .build();

        log.info(fileRepository.save(file));
    }
}
