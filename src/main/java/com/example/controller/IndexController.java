package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
@Controller
public class IndexController {

	@GetMapping("/index")
	public String Index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signUp() {
		return "sign-up";
	}

}
