package com.google.cacheserver;

public interface CacheProvider {
	public CacheEntry get(CacheEntry entry);
	public void put(CacheEntry entry);
	
}
