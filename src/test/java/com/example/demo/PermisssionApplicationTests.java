package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.PermissionRepository;
import com.example.dao.RoleRepository;
import com.example.entity.SysPermission;
import com.example.entity.SysRole;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermisssionApplicationTests {
	@Autowired
	private PermissionRepository permisssionRepository;
	
	@Test
	public void contextLoads() {
		List<SysPermission> list=permisssionRepository.findAll();
		for(SysPermission role:list) {
			System.out.print(role.getPermission()+"zhehsi yig");
		}
	}
	@Test
	public void add() {
		SysPermission p=new SysPermission();
		p.setId(2);
		p.setName("系统管理");
		p.setParentId("0");
	//	p.setParentIds(parentIds);
		p.setPermission("sys");
	//	p.setResourceType(resourceType);
	//	p.setRoles("1");
		p.setUrl("/sys");
		permisssionRepository.save(p);
	}
	
}
