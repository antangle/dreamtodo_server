package org.zerock.b1.dreamtodo.member.dto;

import lombok.Data;

@Data
public class RefreshTokenDTO {

    private String access;

    private String refresh;
}
