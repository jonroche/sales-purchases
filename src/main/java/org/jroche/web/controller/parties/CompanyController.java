package org.jroche.web.controller.parties;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.jroche.common.util.extjs.ResponseMap;
import org.jroche.service.company.CompanyService;
import org.jroche.web.model.user.CompanyUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	private Logger logger = Logger.getAnonymousLogger();
	
	@Autowired
	private CompanyService service;

	@Autowired
	private ResponseMap<CompanyUI> extJS;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) throws Exception {
		model.addAttribute("companyBean", new CompanyUI());
		model.addAttribute("operationName", "add");

		return "company/add";
	}
	
	@RequestMapping(value = "/isSales", method = RequestMethod.GET)
	public @ResponseBody String isSales(Model model) throws Exception {
		String sales = null;
		try {
			logger.info("IN THE IS_SALES_ENABLED FUNCTION");
			sales = String.valueOf(service.findByCompanyName(SecurityContextHolder.getContext().getAuthentication().getName()).isSales());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sales;
	}
	
	@RequestMapping(value = "/isPurchases", method = RequestMethod.GET)
	public @ResponseBody String isPurchases(Model model) throws Exception {
		String pur = null;
		try {
			pur = String.valueOf(service.findByCompanyName(SecurityContextHolder.getContext().getAuthentication().getName()).isPurchases());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pur;
	}
	
	@RequestMapping(value = "/isPayments", method = RequestMethod.GET)
	public @ResponseBody String isPayments(Model model) throws Exception {
		String pur = null;
		try {
			pur = String.valueOf(service.findByCompanyName(SecurityContextHolder.getContext().getAuthentication().getName()).isPayments());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pur;
	}
	
	@RequestMapping(value = "/isParties", method = RequestMethod.GET)
	public @ResponseBody String isParties(Model model) throws Exception {
		String pur = null;
		try {
			pur = String.valueOf(service.findByCompanyName(SecurityContextHolder.getContext().getAuthentication().getName()).isParties());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pur;
	}
	
	@RequestMapping(value = "/isProducts", method = RequestMethod.GET)
	public @ResponseBody String isProducts(Model model) throws Exception {
		String pur = null;
		try {
			pur = String.valueOf(service.findByCompanyName(SecurityContextHolder.getContext().getAuthentication().getName()).isProducts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pur;
	}
	
	@RequestMapping(value = "/getSubscription", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> getSubscription(Model model) throws Exception {
		final Map<String,String> subscription = new HashMap<String, String>(); 
		try {
			CompanyUI company = service.findByCompanyName(SecurityContextHolder.getContext().getAuthentication().getName());
			subscription.put("isSales", String.valueOf(company.isSales()));
			subscription.put("isPurchases", String.valueOf(company.isPurchases()));
			subscription.put("isPayments", String.valueOf(company.isPayments()));
			subscription.put("isParties", String.valueOf(company.isParties()));
			subscription.put("isProducts", String.valueOf(company.isProducts()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subscription;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> add(CompanyUI data) {
		try {
			CompanyUI savedUser = service.create(data);

			if (savedUser != null) {
				return extJS.mapOK(savedUser, "Account Created Succesfully");
			} else {
				return extJS.mapError("Error trying to create account.");
			}
		} catch (Exception e) {
			return extJS.mapError("Error trying to create account.");
		}
	}
}
