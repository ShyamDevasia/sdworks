package com.sdworks.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdworks.auth.vo.MessageVO;

@Controller
@CrossOrigin(origins = "*")
public class SecureController {

	@RequestMapping(value = "/secure", method = RequestMethod.POST)
	@ResponseBody
	public MessageVO secure() {
		MessageVO msg = new MessageVO();
		msg.setFlag(true);
		msg.setMessage("secure-success");
		return msg;
	}
}
