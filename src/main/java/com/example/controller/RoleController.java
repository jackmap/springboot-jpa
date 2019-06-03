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

import com.example.entity.SysRole;
import com.example.service.RoleService;


/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController {
	@Autowired
	public RoleService roleService;

	@GetMapping("/getAll")
	@ResponseBody
	public Page<SysRole> GetIndex() {
		int pageNumber=0,size=10;
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = PageRequest.of(pageNumber, size, sort);
		Page<SysRole> page=roleService.findAll(pageable);
		for (SysRole user:page){
			System.out.println("userDetail: "+user.toString());
		}
		return page;
	}

}
