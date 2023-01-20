package org.zerock.b1.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.b1.common.controller.exceptions.CustomException;
import org.zerock.b1.member.domain.Member;
import org.zerock.b1.member.dto.MemberDTO;
import org.zerock.b1.member.dto.MemberLoginDTO;
import org.zerock.b1.member.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public void insertMember(MemberLoginDTO memberLoginDTO) {
        Member member = modelMapper.map(memberLoginDTO, Member.class);
        memberRepository.save(member);
    }

    @Override
    public long checkLoginInfo(MemberLoginDTO memberLoginDTO) {

        List<Member> memberList = memberRepository.getMemberByUsername(memberLoginDTO.getUsername());
        if(memberList.size() == 0){
            //username match fail
            throw new CustomException(1, "UserMatchFail");
        }

        MemberDTO memberDTO = modelMapper.map(memberList.get(0), MemberDTO.class);

        //password check
        if(!memberDTO.getPassword().equals(memberLoginDTO.getPassword())){
            //password match fail
            throw new CustomException(2, "PasswordMatchFail");
        }

        return memberDTO.getMid().longValue();
    }
}
