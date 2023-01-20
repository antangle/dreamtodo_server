package org.zerock.b1.product.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductListDTO {

    private Long pno;
    private String pname;
    private int price;

    private long reviewCnt;

    private long fancyCnt;
}
