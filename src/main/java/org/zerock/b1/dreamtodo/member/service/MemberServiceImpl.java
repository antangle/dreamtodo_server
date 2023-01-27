package org.zerock.b1.dreamtodo.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.b1.dreamtodo.common.enums.ErrorEnum;
import org.zerock.b1.dreamtodo.common.exceptions.AuthExceptions;
import org.zerock.b1.dreamtodo.common.exceptions.JWTExceptions;
import org.zerock.b1.dreamtodo.member.domain.Member;
import org.zerock.b1.dreamtodo.member.dto.MemberDTO;
import org.zerock.b1.dreamtodo.member.dto.MemberLoginDTO;
import org.zerock.b1.dreamtodo.member.repository.MemberRepository;

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
    public MemberDTO checkLoginInfo(MemberLoginDTO memberLoginDTO) {

        List<Member> memberList = memberRepository.getMemberByUsername(memberLoginDTO.getName());
        if(memberList.size() == 0){
            //username match fail
            throw new AuthExceptions(ErrorEnum.NO_USER);
        }

        MemberDTO memberDTO = modelMapper.map(memberList.get(0), MemberDTO.class);

        //password check
        if(!memberList.get(0).getPassword().equals(memberLoginDTO.getPassword())){
            //password match fail
            throw new AuthExceptions(ErrorEnum.PASSWORD_MISMATCH);
        }

        return memberDTO;
    }
}
