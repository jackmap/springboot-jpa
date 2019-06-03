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

import com.example.entity.SysPression;
import com.example.service.PressionService;


/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
@Controller
@RequestMapping("/sys/pression")
public class PressionController {
	@Autowired
	public PressionService pressionService;

	@GetMapping("/getAll")
	@ResponseBody
	public Page<SysPression> GetIndex() {
		int pageNumber=0,size=10;
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = PageRequest.of(pageNumber, size, sort);
		Page<SysPression> page=pressionService.findAll(pageable);
		return page;
	}

}
