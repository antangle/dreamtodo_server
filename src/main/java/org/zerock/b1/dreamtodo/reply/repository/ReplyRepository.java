package org.zerock.b1.dreamtodo.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.b1.dreamtodo.reply.domain.Reply;
import org.zerock.b1.dreamtodo.reply.dto.ReplyDTO;
import org.zerock.b1.dreamtodo.reply.dto.ReplyListDTO;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {


    //  Todo 삭제되면 같이 삭제
    @Modifying
    @Query(value = "delete from Reply r " +
            "where r.todo.id = :tid")
    void removeReply(@Param("tid") Long tid);

    // Todo Id에 맞는 댓글 가져옴
    // new org.zerock.b1.dreamtodo.reply.dto.ReplyListDTO() -> ReplyListDTO로 받아옴
    @Query(value = "select new org.zerock.b1.dreamtodo.reply.dto.ReplyListDTO(r.contents, r.updateDate, m.name) " +
            "from Member m left join Reply r on r.member = m " +
            "where r.todo.id = :tid")
    List<ReplyListDTO> getReplyList(@Param("tid") Long tid);

}
