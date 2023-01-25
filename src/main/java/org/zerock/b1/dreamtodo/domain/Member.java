package org.zerock.b1.dreamtodo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_member")
@EqualsAndHashCode(callSuper=false, of="mid")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;

    private String name;

    private String password;

    private String role;

    private LocalDate createDate;

    private LocalDate updateDate;
}
