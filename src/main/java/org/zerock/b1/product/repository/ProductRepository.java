package org.zerock.b1.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b1.product.domain.Product;
import org.zerock.b1.product.repository.search.ProductSearch;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductSearch {

}
