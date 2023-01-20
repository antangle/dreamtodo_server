package org.zerock.b1.member.repository.search;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b1.member.domain.Member;
import org.zerock.b1.member.domain.QMember;
import org.zerock.b1.member.dto.MemberDTO;

public class MemberSearchImpl extends QuerydslRepositorySupport implements MemberSearch{
    public MemberSearchImpl() {
        super(Member.class);
    }

    @Override
    public Page<MemberDTO> searchByUsername(Pageable pageable, String username) {
        return null;
    }
}
