package org.zerock.b1.repository;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b1.dreamtodo.member.domain.Member;
import org.zerock.b1.dreamtodo.member.repository.MemberRepository;

import java.util.List;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void test(){
        List<Member> memberList = memberRepository.getMemberByUsername("admin01");
        log.info(memberList);
    }
}
