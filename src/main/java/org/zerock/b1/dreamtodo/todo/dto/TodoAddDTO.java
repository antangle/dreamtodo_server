package org.zerock.b1.dreamtodo.todo.dto;

import lombok.Builder;
import lombok.Data;
import org.zerock.b1.dreamtodo.member.domain.Member;

import java.time.LocalDate;

@Data
@Builder
public class TodoAddDTO {

    private String title;
    private String contents;

    private Member member;

}
