package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.SysPermission;
import com.example.service.PermissionService;


/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
@RestController
@RequestMapping("/sys/permission")
public class PermissionController {
	@Autowired
	public PermissionService permissionService;

	@GetMapping("/getAll")
	@ResponseBody
	public Page<SysPermission> GetIndex() {
		int pageNumber=0,size=10;
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = PageRequest.of(pageNumber, size, sort);
		Page<SysPermission> page=permissionService.findAll(pageable);
		return page;
	}

}
