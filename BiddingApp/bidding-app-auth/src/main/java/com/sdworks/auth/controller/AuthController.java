package com.sdworks.auth.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdworks.auth.services.UserServices;
import com.sdworks.auth.vo.MessageVO;
import com.sdworks.auth.vo.UserVO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	UserServices userServices;
	
	@Value("${bidding.auth.key}")
	private String jwtKey;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	@ResponseBody
	public MessageVO init() {
		MessageVO msg = new MessageVO();
		msg.setFlag(true);
		msg.setMessage("init-success");
		return msg;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public MessageVO doLogin(@RequestBody UserVO uservo) {

		MessageVO msg = new MessageVO();
		String jwtToken = "";
		if (userServices.isUserValid(uservo.getUsername(), uservo.getPassword())) {

			jwtToken = Jwts.builder().setSubject(uservo.getUsername()).claim("roles", "user").setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, jwtKey).compact();
			msg.setFlag(true);
			msg.setMessage(jwtToken);
		}

		return msg;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public MessageVO register(@RequestBody UserVO user) {
		MessageVO msg = new MessageVO();
		if (user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getPassword().isEmpty()) {
			return msg;
		}

		if (userServices.saveUser(user)) {
			msg.setFlag(true);
			msg.setMessage("registration-success");
		}

		return msg;
	}
}
