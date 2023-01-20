package org.zerock.b1.member.domain;

import lombok.*;

import javax.persistence.*;

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
    @Column(name = "tno")
    private Long mid;

    private String password;

    private String username;

}
