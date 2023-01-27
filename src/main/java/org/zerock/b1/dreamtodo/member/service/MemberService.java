package org.zerock.b1.dreamtodo.member.service;

import org.springframework.stereotype.Service;
import org.zerock.b1.dreamtodo.member.dto.MemberDTO;
import org.zerock.b1.dreamtodo.member.dto.MemberLoginDTO;

public interface MemberService {
    public MemberDTO checkLoginInfo(MemberLoginDTO memberLoginDTO);

    public void insertMember(MemberLoginDTO memberLoginDTO);

}
