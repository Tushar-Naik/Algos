package com.google.cacheserver;

import java.util.concurrent.ConcurrentHashMap;

public class BasicCache implements CacheProvider{

	private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

	@Override
	public CacheEntry get(CacheEntry entry) {
		return new CacheEntry(entry.getKey(), map.get(entry.getKey()));
	}

	@Override
	public void put(CacheEntry entry) {
		map.put(entry.getKey(), entry.getValue());
	}
}
