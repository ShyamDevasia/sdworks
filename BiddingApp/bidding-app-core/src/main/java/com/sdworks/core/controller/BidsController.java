package com.sdworks.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BidsController {

	@RequestMapping(value="/testcore", method = RequestMethod.GET)
	@ResponseBody
	public String testGet(){
		return "Hai i am core..";
	}
}
