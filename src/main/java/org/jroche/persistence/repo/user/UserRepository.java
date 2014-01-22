package org.jroche.persistence.repo.user;

import org.jroche.persistence.model.user.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Customer, Long>,
		QueryDslPredicateExecutor<Customer> {

	Customer findByUsername(String username);

	Page<Customer> findByUsernameLike(String username, Pageable pageable);

	Page<Customer> findByFirstNameLike(String firstName, Pageable pageable);

	Page<Customer> findByLastNameLike(String lastName, Pageable pageable);

	Page<Customer> findByFirstNameLikeAndLastNameLike(String firstName,
			String lastName, Pageable pageable);

	@Query("select u from customer u where u.role.role = :role")
	Page<Customer> findByRole(@Param("role") Integer role, Pageable pageable);
}
