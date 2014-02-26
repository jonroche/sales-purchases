package org.jroche.web.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class OverviewController {

	@RequestMapping("/overview")
	public String getOverview() {
		return "overview/overview";
	}
	
	@RequestMapping("/overview/overview")
	public String getOverviewURL() {
		return "overview/overview";
	}
}