package com.google.cacheserver;

import java.io.IOException;

public class BasicSerializer implements Serializer{

	@Override
	public String serialize(CacheEntry entry) throws IOException{
		StringBuffer buffer = new StringBuffer();
		buffer.append("key:"+entry.getKey());buffer.append("||");
		buffer.append("value:"+entry.getValue());
		return buffer.toString();
	}

	@Override
	public SerializerType getType() {
		return SerializerType.BASIC;
	}

	@Override
	public CacheEntry deserialize(String bytes) throws IOException {
		Integer value = Integer.valueOf(bytes.split("\\|\\|")[1].split(":")[1]);
		String key = bytes.split("\\|\\|")[0].split(":")[1];
		return new CacheEntry(key, value);
	}
}
