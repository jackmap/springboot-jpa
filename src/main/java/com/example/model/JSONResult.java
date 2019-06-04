package com.example.model;

import java.util.List;

/**
  *@deprecated:
  *@author作者：mp
  *2019年6月4日
*/
public class JSONResult {
	/**
	  *@deprecated:
	  *@author作者：mp
	  *2019年6月4日
	*/
	public Integer code;
	public String msg;
	public Integer count;
	public List data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
}
