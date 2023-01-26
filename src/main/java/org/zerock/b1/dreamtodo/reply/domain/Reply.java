package org.zerock.b1.dreamtodo.reply.domain;

import lombok.*;
import org.zerock.b1.dreamtodo.member.domain.Member;
import org.zerock.b1.dreamtodo.todo.domain.Todo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_reply")
@EqualsAndHashCode(callSuper=false, of="id")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;

    private LocalDate createDate;

    private LocalDate updateDate;

    @ManyToOne
    private Todo todo;

    @ManyToOne
    private Member member;
}
