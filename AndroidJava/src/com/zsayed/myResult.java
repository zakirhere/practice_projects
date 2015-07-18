package com.zsayed;

public class myResult {
	String jsonName;
	int jsonInt;
	
	public myResult(String name, int val) {
		this.jsonName = name;
		this.jsonInt = val;
	}
	
	public String getName() {
		return jsonName;
	}
	
	public int getIndex() {
		return jsonInt;
	}
	
}
