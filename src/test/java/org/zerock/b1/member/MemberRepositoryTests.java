package org.zerock.b1.member;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b1.member.domain.Member;
import org.zerock.b1.member.dto.MemberDTO;
import org.zerock.b1.member.repository.MemberRepository;

import java.util.List;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;


    @Test
    public void insertMember(){
        Member member = Member.builder()
                        .username("hi")
                        .password("password")
                        .build();
        memberRepository.save(member);
    }

    @Test
    public void getMemberByUsername(){
        List<Member> member = memberRepository.getMemberByUsername("hi");
        log.info(member);
    }
}
