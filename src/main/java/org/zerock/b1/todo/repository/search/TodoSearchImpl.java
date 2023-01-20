package org.zerock.b1.todo.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b1.todo.domain.QReply;
import org.zerock.b1.todo.domain.QTodo;
import org.zerock.b1.todo.domain.Todo;
import org.zerock.b1.todo.dto.TodoListDTO;
import org.zerock.b1.todo.dto.TodoSearchDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> searchList(Pageable pageable, String keyword) {

        log.info("===========================");
        log.info("TodoSearchImpl searchList...");

        QTodo todo = QTodo.todo;

        JPQLQuery<Todo>  query = from(todo);

        query.where(todo.title.like(keyword));

        getQuerydsl().applyPagination(pageable, query);

        log.info(query);

        List<Todo> list = query.fetch();

        long count = query.fetchCount();

        log.info(list);
        log.info(count);



        return null;
    }

    @Override
    public Page<Object[]> searchListWithCount(Pageable pageable) {

        QTodo todo = QTodo.todo;
        QReply reply = QReply.reply;

        JPQLQuery<Todo> query = from(todo)
                .leftJoin(reply)
                .on(reply.todo.id.eq(todo.id))
                .groupBy(todo);

        //페이징 처리
        getQuerydsl().applyPagination(pageable,query);

        log.info(query);

        JPQLQuery<Tuple> tupleJPQLQuery = query.select(todo, reply.count());

        List<Tuple> tupleList = tupleJPQLQuery.fetch();
        long count = tupleJPQLQuery.fetchCount();

        log.info(tupleList);
        log.info(count);

        List<Object[]> objects =
            tupleList.stream().map(tuple -> tuple.toArray()).collect(Collectors.toList());


        return new PageImpl<>(objects, pageable, count);
    }

    @Override
    public Page<TodoListDTO> searchListWithCount2(Pageable pageable, TodoSearchDTO searchDTO) {

        QTodo todo = QTodo.todo;
        QReply reply = QReply.reply;

        JPQLQuery<Todo> query = from(todo)
                .leftJoin(reply)
                .on(reply.todo.id.eq(todo.id))
                .groupBy(todo);

        BooleanBuilder builder = new BooleanBuilder();

        String keyword = searchDTO.getKeyword();


        if(keyword!= null){
            builder.and(todo.title.contains(keyword));
        }

        LocalDate from = searchDTO.getFrom();
        LocalDate to = searchDTO.getTo();
        if(from != null && to != null){

            BooleanBuilder dateBuilder = new BooleanBuilder();
            dateBuilder.and(todo.dueDate.between(from, to));
            builder.and(dateBuilder);
        }

        boolean finish = searchDTO.isFinish();

        if(finish) {
            builder.and(todo.complete.eq(true));
        }

        query.where(builder);

        //페이징 처리
        getQuerydsl().applyPagination(pageable,query);

        log.info(query);

        JPQLQuery<TodoListDTO> projectJPQLQuery =
                query.select(Projections.bean(
                        TodoListDTO.class,
                        todo.id,
                        todo.title,
                        todo.writer,
                        reply.count().as("replyCount")
                ));

        List<TodoListDTO> dtoList = projectJPQLQuery.fetch();
        long count = projectJPQLQuery.fetchCount();

        log.info(dtoList);
        log.info(count);



        return new PageImpl<>(dtoList, pageable, count);
    }
}













