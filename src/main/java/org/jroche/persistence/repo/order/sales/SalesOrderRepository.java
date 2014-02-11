package org.jroche.persistence.repo.order.sales;

import org.jroche.persistence.model.order.sales.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long>,
		QueryDslPredicateExecutor<SalesOrder> {

	public SalesOrder findByOrderId(String orderId);
}
