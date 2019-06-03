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

import com.example.dao.RoleRepository;
import com.example.entity.SysRole;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleApplicationTests {
	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void contextLoads() {
		List<SysRole> list=roleRepository.findAll();
		for(SysRole role:list) {
			System.out.print(role.getId()+"zhehsi yig");
		}
	}

}
