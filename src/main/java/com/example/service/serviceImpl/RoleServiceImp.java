package com.example.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dao.RoleRepository;
import com.example.entity.SysRole;
import com.example.service.RoleService;

/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	public RoleRepository roleRepository;

	@Override
	public SysRole findByName(String name) {
		return roleRepository.findAll().get(0);
	}

	@Override
	public Page<SysRole> findAll(Pageable pageable) {
		Page<SysRole> page=roleRepository.findAll(pageable);
		return page;
	}

	@Override
	public void deleteById(Integer id) {
		roleRepository.deleteById(id);
	}

	@Override
	public void AddSysRole(SysRole role) {
		roleRepository.save(role);
		
	}

	@Override
	public List<SysRole> findAll() {
		return roleRepository.findAll();
	}
}
