package org.zerock.b1.dreamtodo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_reply")
@EqualsAndHashCode(callSuper=false, of="rid")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    private String contents;

    private LocalDate createDate;

    private LocalDate updateDate;

    @ManyToOne
    private Todo todo;

    @ManyToOne
    private Reply reply;
}
