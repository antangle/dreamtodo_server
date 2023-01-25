package org.zerock.b1.dreamtodo.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_todo")
@EqualsAndHashCode(callSuper=false, of="tid")
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

    @Column(name = "mid")
    private String writer;

    private String contents;

    private LocalDate createDate;

    private LocalDate updateDate;

    @ManyToOne
    private Member member;
}
