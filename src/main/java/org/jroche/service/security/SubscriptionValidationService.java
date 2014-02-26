package org.jroche.service.security;

import org.jroche.persistence.repo.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * A custom {@link UserDetailsService} where user information is retrieved from
 * a JPA repository
 */
@Service
public class SubscriptionValidationService  {

	@Autowired
	private CompanyRepository userRepository;

	public boolean isPurchasesEnabled(String username)
			throws UsernameNotFoundException {

		org.jroche.persistence.model.user.Company domainUser = userRepository
				.findByCompanyId(username);
		
		return domainUser.isPurchases();
	}

	public boolean isSalesEnabled(String username)
			throws UsernameNotFoundException {

		org.jroche.persistence.model.user.Company domainUser = userRepository
				.findByCompanyId(username);
		
		return domainUser.isSales();
	}
	
	public boolean isPaymentsEnabled(String username)
			throws UsernameNotFoundException {

		org.jroche.persistence.model.user.Company domainUser = userRepository
				.findByCompanyId(username);
		
		return domainUser.isPayments();
	}
	
	public boolean isPartiesEnabled(String username)
			throws UsernameNotFoundException {

		org.jroche.persistence.model.user.Company domainUser = userRepository
				.findByCompanyId(username);
		
		return domainUser.isParties();
	}
	
	public boolean isProductsEnabled(String username)
			throws UsernameNotFoundException {

		org.jroche.persistence.model.user.Company domainUser = userRepository
				.findByCompanyId(username);
		
		return domainUser.isProducts();
	}
	
}