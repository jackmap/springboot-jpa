package com.example.demo;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.UserRepository;
import com.example.dao.UserRoleRepository;
import com.example.entity.SysUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Test
	public void contextLoads() {
		List<SysUser> list=userRepository.findAll();
		for(SysUser user:list) {
			System.out.print(user.getUid()+"zhehsi yig");
		}
	}
	@Test
	public void addUser() {
		SysUser user=new SysUser();
		user.setName("admin");
		user.setPassword("123");
		String salt = UUID.randomUUID().toString();
		user.setSalt(salt);
		String newPwd = new SimpleHash("MD5", "123", salt, 1024).toHex();
		user.setPassword(newPwd);
		userRepository.save(user);
	}

}
