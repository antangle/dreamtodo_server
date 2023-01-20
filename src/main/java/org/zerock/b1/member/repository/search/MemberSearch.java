package org.zerock.b1.member.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.b1.member.dto.MemberDTO;

public interface MemberSearch {
    Page<MemberDTO> searchByUsername(Pageable pageable, String username);
}
