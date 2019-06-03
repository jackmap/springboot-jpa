package com.example.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dao.UserRepository;
import com.example.entity.SysUser;
import com.example.service.UserService;

/**
  *@deprecated:
  *@author作者：mp
  *2019年6月3日
*/
@Service
public class UserServiceImpl implements UserService {
     
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public SysUser findByName(String name) {
		return userRepository.findAll().get(0);
	}

	@Override
	public Page<SysUser> findAll(Pageable pageable) {
		Page<SysUser> page=userRepository.findAll(pageable);
		return page;
	}
	@Override
	public SysUser findByUserNameOrEmail(String username, String email) {
		return userRepository.findByUserNameOrEmail(username,email);
	}
	@Override
	public SysUser findByEmail(String email) {
		return userRepository.findByUserNameOrEmail(null, email);
	}
	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public void AddSysUser(SysUser user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public List<SysUser> findAll() {
		return userRepository.findAll();
	}
}
