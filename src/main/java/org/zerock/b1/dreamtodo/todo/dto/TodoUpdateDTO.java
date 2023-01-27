package org.zerock.b1.dreamtodo.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class TodoUpdateDTO {

    private Long id;

    private String title;

    private String contents;
}
