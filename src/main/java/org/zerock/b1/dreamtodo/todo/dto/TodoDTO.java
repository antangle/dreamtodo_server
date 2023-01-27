package org.zerock.b1.dreamtodo.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.b1.dreamtodo.file.domain.TFile;
import org.zerock.b1.dreamtodo.file.dto.TFileListDTO;
import org.zerock.b1.dreamtodo.member.domain.Member;
import org.zerock.b1.dreamtodo.reply.domain.Reply;
import org.zerock.b1.dreamtodo.reply.dto.ReplyListDTO;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long id;

    private String title;

    private String contents;

    private String mName;

    private List<ReplyListDTO> replyList;

    private List<TFileListDTO> fileList;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDate;

}

