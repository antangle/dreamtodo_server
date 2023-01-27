package org.zerock.b1.dreamtodo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.b1.dreamtodo.member.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "select m from Member m where m.name = :name")
    List<Member> getMemberByUsername(@Param("name") String name);

}