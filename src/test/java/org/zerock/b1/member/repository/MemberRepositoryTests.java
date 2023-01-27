package org.zerock.b1.member.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b1.dreamtodo.member.domain.Member;
import org.zerock.b1.dreamtodo.member.repository.MemberRepository;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    // tbl_member Insert Test
    @Test
    public void testInserts() {

        Member member = Member.builder()
                .name("admin01")
                .password("1111")
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .role("ROLE_Admin")
                .build();

        log.info(memberRepository.save(member));
    }

    @Test
    public void testGetOne() {

        log.info("Member testGetOnd........");

        Long mid = 1L;

        try{
            log.info("result: " + memberRepository.findById(mid).get());
        } catch (NoSuchElementException e) {
            log.info("No Member id");
        }
    }

}
