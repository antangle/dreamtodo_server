package org.zerock.b1.dreamtodo.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.b1.dreamtodo.reply.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Modifying
    @Query(value = "delete from Reply r " +
            "where r.todo.id = :tid")
    void removeReply(@Param("tid") Long tid);

}
