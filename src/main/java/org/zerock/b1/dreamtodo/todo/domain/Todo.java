package org.zerock.b1.dreamtodo.todo.domain;

import lombok.*;
import org.zerock.b1.dreamtodo.file.domain.TFile;
import org.zerock.b1.dreamtodo.member.domain.Member;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_todo")
@EqualsAndHashCode(callSuper=false, of="id")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private Long id;

    private String title;

    private String contents;

    private LocalDate regDate;

    private LocalDate createDate;

    private LocalDate regDate;

    private LocalDate updateDate;

    @ManyToOne
    private Member member;

}
