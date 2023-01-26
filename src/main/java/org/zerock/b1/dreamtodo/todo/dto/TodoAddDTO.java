package org.zerock.b1.dreamtodo.todo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TodoAddDTO {

    private String title;
    private String writer;
    private LocalDate dueDate;
}
