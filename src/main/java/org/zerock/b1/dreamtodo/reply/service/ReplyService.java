package org.zerock.b1.dreamtodo.reply.service;

import org.zerock.b1.dreamtodo.reply.dto.ReplyAddDTO;
import org.zerock.b1.dreamtodo.reply.dto.ReplyDTO;
import org.zerock.b1.dreamtodo.reply.dto.ReplyUpdateDTO;

public interface ReplyService {

    ReplyDTO add(ReplyAddDTO dto);

    ReplyDTO modify(ReplyUpdateDTO dto);
}
