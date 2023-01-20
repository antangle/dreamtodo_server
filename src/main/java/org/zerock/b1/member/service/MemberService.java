package org.zerock.b1.member.service;

import org.zerock.b1.member.dto.MemberLoginDTO;

public interface MemberService {

    public long checkLoginInfo(MemberLoginDTO memberLoginDTO);

    public void insertMember(MemberLoginDTO memberLoginDTO);
}