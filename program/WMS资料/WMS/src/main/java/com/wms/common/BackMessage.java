package com.wms.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BackMessage {
	//信息编号
	private int code;
	//信息内容
	private String message;
	//数目
	private int count;
	//信息map
	private  final Map<String, Object> datas = new HashMap<String, Object>();
	public int getCode() {
		return code;
	}
	private List<?> data;
	private List<?> data1;
	
	public BackMessage(int code, String message, List<?> data) {
		// TODO Auto-generated constructor stub
		super();
		this.code = code;
		this.message = message;
		this.count = data.size();
		this.data = data;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
	
	public Map<String, Object> getDatas() {
		return datas;
	}
	
	public List<?> getData() {
		return data;
	}
	
	public void setData(List<?> data) {
		this.data = data;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BackMessage(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public BackMessage(int code, String message, int count, List<Object> data) {
		super();
		this.code = code;
		this.message = message;
		this.count = count;
		this.data = data;
	}
	
	
	
	public BackMessage putDataValue(String key, Object value) {
		this.datas.put(key, value);
		return this;
	}
	public List<?> getData1() {
		return data1;
	}
	public void setData1(List<?> data1) {
		this.data1 = data1;
	}
	
	
	

}
