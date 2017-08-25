package com.sdworks.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdworks.core.config.AppConfiguration;

@Controller
public class BidsController {

	@Autowired
	private AppConfiguration appConfiguration;

	@Value("${jwt.property}")
	private String jwtProperty;

	@RequestMapping(value = "/testcore", method = RequestMethod.GET)
	@ResponseBody
	public String testGet() {
		return "Hai i am core..";
	}

	@RequestMapping(value = "/testconfig", method = RequestMethod.GET)
	@ResponseBody
	public String testConfig() {
		StringBuilder sb = new StringBuilder();
		sb.append(appConfiguration.getProperty());
		sb.append(" || ");
		sb.append(jwtProperty);

		return sb.toString();
	}
}
