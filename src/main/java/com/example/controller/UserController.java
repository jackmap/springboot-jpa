package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.SysUser;

/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {
	@Autowired
	public com.example.service.UserService UserService;

	@GetMapping("/getAll")
	@ResponseBody
	public Page<SysUser> GetIndex() {
		int pageNumber = 0, size = 10;
		Sort sort = new Sort(Sort.Direction.DESC, "uid");
		Pageable pageable = PageRequest.of(pageNumber, size, sort);
		Page<SysUser> page = UserService.findAll(pageable);
		for (SysUser user : page) {
			System.out.println("userDetail: " + user.toString());
		}
		return page;
	}

	@GetMapping("/deleteById")
	@ResponseBody
	public void DeleteById(Integer id) {
		UserService.deleteById(id);
		;
	}

	@GetMapping("/save")
	@ResponseBody
	public void Save(SysUser user) {
		UserService.AddSysUser(user);
	}

	@GetMapping("/update")
	@ResponseBody
	public void Update(SysUser user) {
		UserService.AddSysUser(user);
	}

}
