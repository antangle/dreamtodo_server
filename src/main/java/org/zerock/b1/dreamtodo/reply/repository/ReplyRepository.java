package org.zerock.b1.dreamtodo.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b1.dreamtodo.reply.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
