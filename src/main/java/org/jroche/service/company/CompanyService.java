package org.jroche.service.company;

import java.util.List;

import org.apache.log4j.Logger;
import org.jroche.common.util.extjs.FilterRequest;
import org.jroche.common.util.mapper.company.CompanyMapper;
import org.jroche.persistence.model.user.Company;
import org.jroche.persistence.model.user.QCustomer;
import org.jroche.persistence.model.user.Customer.COLUMNS;
import org.jroche.persistence.repo.company.CompanyRepository;
import org.jroche.web.model.user.CompanyUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	private Logger logger = Logger.getLogger(CompanyService.class);

	private CompanyMapper mapper = new CompanyMapper();

	public CompanyUI create(CompanyUI uiBean) {

		Company newCompany = mapper.toPersistenceBean(uiBean);
		Company saved = repository.save(newCompany);
		logger.debug("Created Account : " + saved);

		return mapper.toUIBean(saved);
	}

	public Company find(Company company) {
		return company;
	}

	public List<CompanyUI> findAll() {
		return mapper.toUIBean(repository.findAll());
	}

	public Page<CompanyUI> findAll(Pageable pageable, List<FilterRequest> filters) {

		Predicate predicate = toPredicate(filters);

		return mapper.toUIBean(repository.findAll(predicate, pageable),
				pageable);
	}

	public CompanyUI findByCompanyName(String companyName) {
		return mapper.toUIBean(repository.findByCompanyName(companyName));
	}

	public CompanyUI findByCompanyId(String companyId) {
		return mapper.toUIBean(repository.findByCompanyName(companyId));
	}
	

	private Predicate toPredicate(final List<FilterRequest> filters) {
		logger.info("Entering predicates :: " + filters);
		QCustomer user = QCustomer.user;
		BooleanExpression result = null;

		try {
			for (FilterRequest filter : filters) {

				COLUMNS column = COLUMNS.valueOf(filter.getProperty()
						.toUpperCase());
				BooleanExpression expression = null;

				switch (column) {
				case USERNAME:
					if (filter.getValue() != null
							&& !"".equals(filter.getValue())) {
						expression = user.username.like(filter.getValue());
					}
					break;
				case FIRSTNAME:
					if (filter.getValue() != null
							&& !"".equals(filter.getValue())) {
						expression = user.firstName.like("%"
								+ filter.getValue() + "%");
					}
					break;
				case LASTNAME:
					if (filter.getValue() != null
							&& !"".equals(filter.getValue())) {
						expression = user.lastName.like("%" + filter.getValue()
								+ "%");
					}
					break;
				case ACCOUNTTYPE:
					if (filter.getValue() != null
							&& !"".equals(filter.getValue())) {
						expression = user.accountType.like("%"
								+ filter.getValue() + "%");
					}
					break;
				}
				if (expression != null) {
					if (result != null) {
						result = result.and(expression);
					} else {
						result = expression;
					}
				}
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		logger.info("Result Predicate :: "
				+ (result != null ? result.toString() : ""));

		logger.info("Exiting predicates");
		return result;
	}
}
