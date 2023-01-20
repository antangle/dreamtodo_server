package org.zerock.b1.product.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.b1.product.dto.ProductListDTO;

public interface ProductSearch {

    Page<ProductListDTO> getList(Pageable pageable);

}
