package org.zerock.b1.dreamtodo.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.b1.dreamtodo.member.dto.MemberDTO;
import org.zerock.b1.dreamtodo.member.repository.MemberRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public MemberDTO getOne(Long id) {


        return null;
    }
}
