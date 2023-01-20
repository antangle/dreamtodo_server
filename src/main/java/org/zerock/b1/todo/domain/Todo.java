package org.zerock.b1.todo.domain;


import lombok.*;
import org.zerock.b1.common.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tbl_todo")
@EqualsAndHashCode(callSuper=false, of="id")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tno")
    private Long id;

    private String title;

    private String writer;

    private LocalDate dueDate;

    private boolean complete;

    private String str;

}














