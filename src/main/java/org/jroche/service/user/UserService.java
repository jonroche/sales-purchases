package org.jroche.service.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.jroche.common.util.extjs.FilterRequest;
import org.jroche.common.util.mapper.user.UserMapper;
import org.jroche.persistence.model.user.Customer;
import org.jroche.persistence.model.user.QCustomer;
import org.jroche.persistence.model.user.Customer.COLUMNS;
import org.jroche.persistence.repo.user.UserRepository;
import org.jroche.web.model.user.UserUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	private Logger logger = Logger.getLogger(UserService.class);

	private UserMapper mapper = new UserMapper();

	public UserUI create(UserUI uiBean) {

		Customer newUser = mapper.toPersistenceBean(uiBean);
		Customer saved = repository.save(newUser);
		logger.debug("Created Account : " + saved);

		return mapper.toUIBean(saved);
	}

	public Customer find(Customer user) {
		return user;
	}

	public List<UserUI> findAll() {
		return mapper.toUIBean(repository.findAll());
	}

	public Page<UserUI> findAll(Pageable pageable, List<FilterRequest> filters) {

		Predicate predicate = toPredicate(filters);

		return mapper.toUIBean(repository.findAll(predicate, pageable),
				pageable);
	}

	public UserUI findByUsername(String userName) {
		return mapper.toUIBean(repository.findByUsername(userName));
	}

	public UserUI update(UserUI uiBean) {
		Customer existingUser = repository.findByUsername(uiBean.getUsername());

		if (existingUser == null) {
			return null;
		}

		existingUser.setFirstName(uiBean.getFirstName());
		existingUser.setLastName(uiBean.getLastName());
		existingUser.setBillingAddress(uiBean.getBillingAddress());
		existingUser.setDescription(uiBean.getDescription());
		existingUser.setEmail(uiBean.getEmail());
		existingUser.setMobilePhone(uiBean.getMobilePhone());
		existingUser.setNotes(uiBean.getNotes());
		existingUser.setOfficePhone(uiBean.getOfficePhone());

		Customer saved = null;

		try {
			saved = repository.save(existingUser);
		} catch (Exception e) {
			logger.error(e);
		}

		return mapper.toUIBean(saved);
	}

	public Boolean delete(UserUI user) {
		Customer existingUser = repository.findByUsername(user.getUsername());

		if (existingUser == null) {
			return false;
		}

		repository.delete(existingUser);
		return true;
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
