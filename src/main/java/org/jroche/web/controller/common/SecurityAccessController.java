package org.jroche.web.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class SecurityAccessController {

	@RequestMapping("/login")
	public String login(Model model, @RequestParam(required=false) String message) {
		model.addAttribute("message", message);
		return "security/login";
	}
	
	@RequestMapping("/company/add")
	public String add(Model model, @RequestParam(required=false) String message) {
		model.addAttribute("message", message);
		return "company/add";
	}
	
	@RequestMapping(value = "/denied")
 	public String denied() {
		return "security/denied";
	}
	
	@RequestMapping(value = "/login/failure")
 	public String loginFailure() {
		String message = "Login Failure!";
		return "redirect:/login?message="+message;
	}
	
	@RequestMapping(value = "/logout/success")
 	public String logoutSuccess() {
		String message = "Logout Success!";
		return "redirect:/login?message="+message;
	}
	
	@RequestMapping(value = "/company/add/failure")
 	public String addCompanyFailure() {
		String message = "Register Failure!";
		return "redirect:/login?message="+message;
	}
	
	@RequestMapping(value = "/company/add/success")
 	public String addCompanySuccess() {
		String message = "Register Success - Please Login";
		return "redirect:/login?message="+message;
	}
}