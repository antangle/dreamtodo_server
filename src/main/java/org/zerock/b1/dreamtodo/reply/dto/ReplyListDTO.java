package org.zerock.b1.dreamtodo.reply.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyListDTO {

    private String contents;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDate;

    private String mName;
}
