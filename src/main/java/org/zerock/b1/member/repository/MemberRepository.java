package org.zerock.b1.member.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.b1.member.domain.Member;
import org.zerock.b1.member.dto.MemberDTO;
import org.zerock.b1.member.repository.search.MemberSearch;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberSearch {

    @Query(value = "select m from Member m where m.username = :username")
    List<Member> getMemberByUsername(@Param("username") String username);

    Page<MemberDTO> searchByUsername(Pageable pageable, String username);

}
