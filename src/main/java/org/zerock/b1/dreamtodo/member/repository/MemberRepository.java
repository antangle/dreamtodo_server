package org.zerock.b1.dreamtodo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b1.dreamtodo.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
