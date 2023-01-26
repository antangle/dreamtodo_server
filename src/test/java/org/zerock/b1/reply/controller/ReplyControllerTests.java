package org.zerock.b1.reply.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b1.dreamtodo.member.domain.Member;
import org.zerock.b1.dreamtodo.member.repository.MemberRepository;
import org.zerock.b1.dreamtodo.reply.dto.ReplyAddDTO;
import org.zerock.b1.dreamtodo.reply.repository.ReplyRepository;
import org.zerock.b1.dreamtodo.reply.service.ReplyService;

@SpringBootTest
@Log4j2
public class ReplyControllerTests {

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testAdd() {

        log.info("Reply testAdd..........");

        Member member = memberRepository.findById(1L).get();

        ReplyAddDTO dto = ReplyAddDTO.builder()
                .tid(1L)
                .member(member)
                .contents("testContents...")
                .build();

        replyService.add(dto);
    }
}
