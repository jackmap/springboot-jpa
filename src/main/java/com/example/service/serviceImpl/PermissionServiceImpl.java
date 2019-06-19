package com.example.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dao.PermissionRepository;
import com.example.entity.SysPermission;
import com.example.service.PermissionService;

/**
  *@deprecated:
  *@author作者：mp
  *2019年6月3日
*/
@Service
public class PermissionServiceImpl implements PermissionService {
     
	@Autowired
	public PermissionRepository permissionRepository;
	
	@Override
	public SysPermission findByName(String name) {
		return permissionRepository.findAll().get(0);
	}

	@Override
	public void deleteById(Integer id) {
		permissionRepository.deleteById(id);		
	}

	@Override
	public void AddSysPression(SysPermission entity) {
		permissionRepository.save(entity);
	}

	@Override
	public List<SysPermission> findAll() {
		return permissionRepository.findAll();
	}

	@Override
	public Page<SysPermission> findAll(Pageable pageable) {
		Page<SysPermission> page=permissionRepository.findAll(pageable);
		return page;
	}
}
