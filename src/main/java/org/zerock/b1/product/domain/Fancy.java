package org.zerock.b1.product.domain;

import lombok.*;
import org.zerock.b1.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fancy")
@EqualsAndHashCode(callSuper=false, of="fno")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fancy extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    @ManyToOne
    private Product product;

    private String fwriter;
}



