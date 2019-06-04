package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.PermissionRepository;
import com.example.dao.UserRepository;
import com.example.entity.SysPermission;
import com.example.entity.SysUser;
import com.example.service.PermissionService;

/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
@Controller
public class IndexController {
	
	@Autowired
	public PermissionRepository permissionRepository;
	@GetMapping("/layout")
	public String layout(ModelMap map) {
		map.addAttribute("Permissions", getPermissionList());
		return "layout";
	}
	@GetMapping("/index")
	public String Index(ModelMap map) {
	    map.addAttribute("Permissions", getPermissionList());
		return "index";
	}

	private List<SysPermission> getPermissionList() {
		return permissionRepository.findAll();
	}
   
	
}
