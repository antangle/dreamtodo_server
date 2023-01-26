package org.zerock.b1.dreamtodo.file.domain;

import lombok.*;
import org.zerock.b1.dreamtodo.todo.domain.Todo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_file")
@EqualsAndHashCode(callSuper=false, of="id")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fid")
    private Long id;

    private String uuid;

    private LocalDate createDate;

    private LocalDate updateDate;

    @ManyToOne
    private Todo todo;
}
