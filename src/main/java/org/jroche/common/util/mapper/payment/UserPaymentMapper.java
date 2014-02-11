package org.jroche.common.util.mapper.payment;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jroche.persistence.model.payments.UserPayment;
import org.jroche.persistence.model.user.Customer;
import org.jroche.web.model.payments.UserPaymentUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class UserPaymentMapper {

	Logger logger = Logger.getLogger(UserPaymentMapper.class);

	public UserPaymentUI toUIBean(UserPayment data) {
		UserPaymentUI uiBean = null;

		if (data != null) {
			uiBean = new UserPaymentUI();
			uiBean.setAmount(data.getAmount());
			uiBean.setId(data.getId());
			uiBean.setNotes(data.getNotes());
			uiBean.setPaymentDate(data.getPaymentDate());
			uiBean.setPaymentType(data.getPaymentType());
			if (data.getCustomer() != null) {
				uiBean.setUserName(data.getCustomer().getUsername());
			}
		}

		logger.debug("Payment is :: " + uiBean);

		return uiBean;
	}

	public List<UserPaymentUI> toUIBean(List<UserPayment> payments) {
		List<UserPaymentUI> uiBeans = new ArrayList<UserPaymentUI>();

		for (UserPayment payment : payments) {
			uiBeans.add(toUIBean(payment));
		}
		return uiBeans;
	}

	public Page<UserPaymentUI> toUIBean(Page<UserPayment> payments,
			Pageable pageable) {
		Page<UserPaymentUI> uiBeans = new PageImpl<UserPaymentUI>(
				toUIBean(payments.getContent()), pageable,
				payments.getTotalElements());

		return uiBeans;
	}

	public UserPayment toPersistenceBean(UserPaymentUI uiBean) {
		UserPayment data = null;

		if (uiBean != null) {
			data = new UserPayment();
			data.setAmount(uiBean.getAmount());
			data.setId(uiBean.getId());
			data.setNotes(uiBean.getNotes());
			data.setPaymentDate(uiBean.getPaymentDate());
			data.setPaymentType(uiBean.getPaymentType());

			Customer customer = new Customer();
			customer.setUsername(uiBean.getUserName());
			data.setCustomer(customer);
		}
		return data;
	}

	public List<UserPayment> toPersistenceBean(List<UserPaymentUI> uiBeans) {
		List<UserPayment> payments = new ArrayList<UserPayment>();

		for (UserPaymentUI uiBean : uiBeans) {
			payments.add(toPersistenceBean(uiBean));
		}
		return payments;
	}
}
