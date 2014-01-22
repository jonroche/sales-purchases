package org.jroche.web.controller.parties;

import java.util.Map;

import org.jroche.common.util.extjs.ResponseMap;
import org.jroche.service.company.CompanyService;
import org.jroche.web.model.user.CompanyUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/company")
public class CompanyController {
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
