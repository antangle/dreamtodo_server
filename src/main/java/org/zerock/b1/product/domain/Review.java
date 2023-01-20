package org.zerock.b1.product.domain;

import lombok.*;
import org.zerock.b1.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_review")
@EqualsAndHashCode(callSuper=false, of="rno")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne
    private Product product;

    private String text;

}
