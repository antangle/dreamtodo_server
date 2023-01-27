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
import org.zerock.b1.dreamtodo.reply.dto.ReplyListDTO;
import org.zerock.b1.dreamtodo.reply.repository.ReplyRepository;
import org.zerock.b1.dreamtodo.todo.domain.Todo;
import org.zerock.b1.dreamtodo.todo.dto.TodoAddDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoDTO;
import org.zerock.b1.dreamtodo.todo.dto.TodoUpdateDTO;
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

    private final TFileRepository fileRepository;

    private final ModelMapper modelMapper;

    // Todo 상세 페이지 출력
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

        List<ReplyListDTO> replyList = replyRepository.getReplyList(id);

        List<TFileListDTO> fileList = fileRepository.getTFileList(id);

        Todo todo = todoRepository.findById(id).get();

        TodoDTO todoDTO = TodoDTO.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .contents(todo.getContents())
                .mName(todo.getMember().getName())
                .replyList(replyList)
                .fileList(fileList)
                .createDate(todo.getCreateDate())
                .updateDate(todo.getUpdateDate())
                .build();

        return todoDTO;

    }


    // Todo 추가
    @Override
    public TodoDTO add(TodoAddDTO dto) {

        Todo todo = Todo.builder()
                .title(dto.getTitle())
                .contents(dto.getContents())
                .member(dto.getMember())
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .regDate(LocalDate.now())
                .build();
        todoRepository.save(todo);


        return modelMapper.map(todo, TodoDTO.class);
    }


    // Todo 수정
    @Override
    public TodoDTO modify(TodoUpdateDTO dto) {

        log.info("Todo modify..........");

        // 기존 Temp Entity
        Todo temp = todoRepository.findById(dto.getId()).get();

        Todo todo = Todo.builder()
                .id(temp.getId())
                .title(dto.getTitle())
                .contents(dto.getContents())
                .createDate(temp.getCreateDate())
                .updateDate(LocalDate.now())
                .regDate(temp.getRegDate())
                .member(temp.getMember())
                .build();

        return modelMapper.map(todoRepository.save(todo), TodoDTO.class);
    }

    @Override
    public void remove(Long id) {

        log.info("Todo remove......");

        //replyRepository.removeReply(id);
        fileRepository.removeTFile(id);


        todoRepository.deleteById(id);
    }
}
