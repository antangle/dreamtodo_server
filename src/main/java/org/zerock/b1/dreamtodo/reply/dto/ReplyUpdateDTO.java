package org.zerock.b1.dreamtodo.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyUpdateDTO {

    private Long id;

    private String contents;
}
