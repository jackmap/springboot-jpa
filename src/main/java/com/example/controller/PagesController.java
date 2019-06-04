package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
  *@deprecated:
  *@author作者：mp
  *2019年6月4日
*/
@Controller
public class PagesController {
	
	 /**
     * 系统设置页面*/
	@GetMapping("/sys/user")
	public String User() {
		return "pages/sys/user";
	}
	@GetMapping("/sys/role")
	public String Role() {
		return "pages/sys/role";
	}
	@GetMapping("/sys/permission")
	public String Permission() {
		return "pages/sys/permission";
	}
	@GetMapping("/sys/pwd")
	public String PWD() {
		return "pages/sys/pwd";
	}
}
