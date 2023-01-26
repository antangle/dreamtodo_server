package org.zerock.b1.dreamtodo.todo.repository.search;

import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b1.dreamtodo.todo.domain.QTodo;
import org.zerock.b1.dreamtodo.todo.domain.Todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    /** Query DSL Constructor**/
    public TodoSearchImpl() { super(Todo.class); }

    /** 달력에서 선택한 날짜의 Todo리스트 찾기 **/
    @Override
    public Page<Todo> searchWithDate(Pageable pageable, String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate selectedDate = LocalDate.parse(date, formatter);

        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = from(todo);

        query.where(todo.regDate.eq(selectedDate));
        log.info("------date------");
        log.info(selectedDate);

        // 페이징 처리
        getQuerydsl().applyPagination(pageable, query);

        log.info("------query------");
        log.info(query);

        List<Todo> list = query.fetch();

        log.info("------fetched list------");
        log.info(list);

        return new PageImpl<>(list);
    }
}
