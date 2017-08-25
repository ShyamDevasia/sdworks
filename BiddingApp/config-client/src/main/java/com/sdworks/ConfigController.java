package com.sdworks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
	
	@Value("${jwt.key}")
	private String jwtKey;
	
	@RequestMapping("/test")
	public String testConfig(){
		StringBuilder sb = new StringBuilder();
		sb.append("|");
		sb.append(jwtKey);
		return sb.toString();
	}
}
