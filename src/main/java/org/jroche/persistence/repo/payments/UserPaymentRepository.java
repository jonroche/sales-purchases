package org.jroche.persistence.repo.payments;

import java.util.List;

import org.jroche.persistence.model.payments.UserPayment;
import org.jroche.persistence.model.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserPaymentRepository extends
		JpaRepository<UserPayment, Long>,
		QueryDslPredicateExecutor<UserPayment> {

	List<UserPayment> findByCustomer(Customer customer);

	UserPayment findById(Long id);

}
