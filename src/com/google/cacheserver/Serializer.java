package com.google.cacheserver;

import java.io.IOException;

public interface Serializer {
	public enum SerializerType{BASIC};
	public SerializerType getType();
	public String serialize(CacheEntry entry) throws IOException;
	public CacheEntry deserialize(String bytes) throws IOException;
	
}
