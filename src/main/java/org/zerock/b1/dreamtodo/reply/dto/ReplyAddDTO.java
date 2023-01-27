package org.zerock.b1.dreamtodo.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.b1.dreamtodo.member.domain.Member;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyAddDTO {

    private Long tid;

    private String contents;

    private Member member;
}
