package org.zerock.b1.dreamtodo.member.dto;

import lombok.Data;

@Data
public class MemberAddDTO {

    private Long mid;

    private String name;

    private String password;

    private String role;
}
