package org.zerock.b1.product.domain;


import lombok.*;
import org.zerock.b1.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_product")
@EqualsAndHashCode(callSuper=false, of="pno")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String pname;

    private int price;


}
















