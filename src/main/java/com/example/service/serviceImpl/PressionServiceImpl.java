package com.example.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dao.PressionRepository;
import com.example.entity.SysPression;
import com.example.entity.SysUser;
import com.example.service.PressionService;

/**
  *@deprecated:
  *@author作者：mp
  *2019年6月3日
*/
@Service
public class PressionServiceImpl implements PressionService {
     
	@Autowired
	public PressionRepository pressionRepository;
	
	@Override
	public SysPression findByName(String name) {
		return pressionRepository.findAll().get(0);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddSysPression(SysUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SysPression> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SysPression> findAll(Pageable pageable) {
		Page<SysPression> page=pressionRepository.findAll(pageable);
		return page;
	}
}
