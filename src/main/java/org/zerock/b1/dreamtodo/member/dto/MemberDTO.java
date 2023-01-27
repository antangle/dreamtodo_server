package org.zerock.b1.dreamtodo.member.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberDTO {

    private Long mid;

    private String name;

    private String role;

    private LocalDate createDate;

    private LocalDate updateDate;

}