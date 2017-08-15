package com.sdworks.auth.controller;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdworks.auth.domain.UserDetails;
import com.sdworks.auth.repository.AuthRepository;
import com.sdworks.auth.vo.MessageVO;
import com.sdworks.auth.vo.UserVO;

@Controller
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	AuthRepository authRepository;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	@ResponseBody
	public MessageVO init() {

		UserDetails user1 = new UserDetails();
		user1.setUsername("sdworks");
		user1.setPassword("admin");
		user1.setEmail("sd.my.online@gmail.com");
		authRepository.save(user1);

		MessageVO msg = new MessageVO();
		msg.setFlag(true);
		msg.setMessage("init-success");
		return msg;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public MessageVO doLogin(@RequestBody UserVO uservo) {

		MessageVO msg = new MessageVO();

		try {
			UserDetails user = authRepository.findByUsername(uservo.getUsername());
			if (user != null && uservo.getPassword().equals(user.getPassword())) {
				msg.setFlag(true);
				msg.setMessage("valid");
			}
		} catch (NonUniqueResultException e) {
			return msg;
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

		UserDetails newUser = new UserDetails();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		try {
			authRepository.save(newUser);
			msg.setFlag(true);
			msg.setMessage("registration-success");
		} catch (Exception e) {
			return msg;
		}

		return msg;
	}
}
