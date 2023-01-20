package org.zerock.b1.todo.dto;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Data
public class TodoAddDTO {

    private String title;
    private String writer;
    private LocalDate dueDate;

}
