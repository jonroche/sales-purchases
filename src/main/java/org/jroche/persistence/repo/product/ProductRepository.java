package org.jroche.persistence.repo.product;

import org.jroche.persistence.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductRepository extends JpaRepository<Product, Long>,
		QueryDslPredicateExecutor<Product> {

	Product findByProductName(String productName);

}
