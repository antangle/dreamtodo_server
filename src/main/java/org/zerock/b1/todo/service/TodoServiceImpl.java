package org.zerock.b1.todo.service;

/*
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.b1.common.dto.PageReqDTO;
import org.zerock.b1.common.dto.PageResultDTO;
import org.zerock.b1.todo.domain.Todo;
import org.zerock.b1.todo.dto.TodoAddDTO;
import org.zerock.b1.todo.dto.TodoDTO;
import org.zerock.b1.todo.dto.TodoListDTO;
import org.zerock.b1.todo.repository.ReplyRepository;
import org.zerock.b1.todo.repository.TodoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    private final ReplyRepository replyRepository;

    private final ModelMapper modelMapper;

    @Override
    public TodoDTO add(TodoAddDTO todoAddDTO) {


        Todo entity = modelMapper.map(todoAddDTO, Todo.class);

        Todo result = todoRepository.save(entity);

        TodoDTO todoDTO = modelMapper.map(result, TodoDTO.class);

        return todoDTO;
    }

    @Override
    public PageResultDTO<TodoListDTO> getList(PageReqDTO pageReqDTO) {

        log.info("getList....................");

        Pageable pageable = pageReqDTO.getPageable(Sort.by("id").descending());

        Page<Object[]> result = todoRepository.searchListWithCount(pageable);

        //List<Object[]>
        List<TodoListDTO> list = result.getContent().stream().map(arr -> {

            Todo entity = (Todo)arr[0];
            long count = (long)arr[1];
            TodoListDTO dto = modelMapper.map(entity, TodoListDTO.class);
            dto.setReplyCount(count);

            return dto;
        }).collect(Collectors.toList());

        PageResultDTO<TodoListDTO> pageResultDTO =
                new PageResultDTO<>(list,pageable, result.getTotalElements(), result.getTotalPages() );

        return pageResultDTO;

    }

    @Override
    public TodoDTO getOne(Long id) {

        log.info("================================");
        log.info(todoRepository.getClass().getName());

        Optional<Todo> result = todoRepository.findById(id);

        Todo todo = result.orElseThrow();

        return modelMapper.map(todo, TodoDTO.class);
    }

    @Override
    public void remove(Long id) {

        replyRepository.deleteWithTodo(id);

        todoRepository.deleteById(id);


    }

}
*/