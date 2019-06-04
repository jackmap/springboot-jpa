package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.example.entity.SysUser;
import com.example.model.JSONResult;
import com.example.model.PageModel;

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
	public JSONResult GetUsers(PageModel pagemodel) {
		JSONResult result=new JSONResult();
		Sort sort = new Sort(Sort.Direction.DESC, "uid");
		Pageable pageable = PageRequest.of(pagemodel.getPage()-1, pagemodel.getLimit(), sort);
		Page<SysUser> page = UserService.findAll(pageable);
		result.setCode(0);
		result.setData(page.getContent());
		result.setCount(page.getTotalPages());
		return result;
	}

	@DeleteMapping("/deleteById")
	@ResponseBody
	public void DeleteById(Integer id) {
		UserService.deleteById(id);
	}

	@PostMapping("/save")
	@ResponseBody
	public void Save(SysUser user) {
		UserService.AddSysUser(user);
	}

	@PostMapping("/update")
	@ResponseBody
	public void Update(SysUser user) {
		UserService.AddSysUser(user);
	}

}
