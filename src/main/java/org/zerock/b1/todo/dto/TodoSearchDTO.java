package org.zerock.b1.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoSearchDTO {

    private String keyword;

    private LocalDate from;

    private LocalDate to;

    private boolean finish;

}
