package com.google.cacheserver;

public class CacheEntry {

	private String key;
	private Integer value;
	
	public CacheEntry(String key, Integer value){
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Integer getValue() {
		return value;
	}
	
	
}
