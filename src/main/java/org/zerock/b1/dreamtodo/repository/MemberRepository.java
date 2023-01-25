package org.zerock.b1.dreamtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b1.dreamtodo.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
