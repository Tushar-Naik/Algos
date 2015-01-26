package com.flipkart.programs;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.yahoo.algos.MurmurHash;

public class ConsitentHashing<T> {

	/**
	 * @param args
	 */
	
	private final SortedMap<Integer, T> circle = new TreeMap<Integer, T>();
	private final int replicaNum;
	private final HashFunction hashFunction;
	
	public ConsitentHashing(List<T> nodes, int replicaNum , HashFunction hashFunction){
		this.replicaNum = replicaNum;
		this.hashFunction = hashFunction;
		//Calling a function from Constructor but its final hence cant be overriden by subclass for unsafe publication on init
		for(T node: nodes){
			addNode(node);
		}
		
		System.out.println(this.circle);
	}
	
	public final void addNode(T node){
		for (int i=0;i<replicaNum;i++){
			circle.put(hashFunction.getHash(node.toString()+i), node);
		}
	}
	
	public void removeNode(T node){
		for (int i=0;i<replicaNum;i++){
			circle.remove(hashFunction.getHash(node.toString()+i));
		}
	}
	
	
	public T get(Object key){
		int hash = hashFunction.getHash(key.toString());
		//System.out.println(hash);
		if(!circle.containsKey(hash)){
			SortedMap<Integer, T> tailMap = circle.tailMap(hash);
			hash = tailMap.isEmpty()?circle.firstKey():tailMap.firstKey();
		}
		return circle.get(hash);
	}
	
	public static void main(String[] args) {
		List<String> nodes = new ArrayList<String>();
		nodes.add("host1.a.b.com");
		nodes.add("host2.a.b.com");
		nodes.add("host3.a.b.com");
		nodes.add("host4.a.b.com");
		ConsitentHashing<String> hashing = new ConsitentHashing<String>(nodes, 2, new MurmerHashing());
		
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		for(int i = 0;i<5000;i++){
			String uuid = UUID.randomUUID().toString();
			String node = hashing.get(uuid);
			if(map.containsKey(node)){
				map.put(node, (map.get(node)+1));
			}else{
				map.put(node,1);
			}
		}
		System.out.println(map);
	}
}

interface HashFunction{
	public abstract int getHash(String key);
}

class MD5Hashing implements HashFunction{
	@Override
	/*
	 * Defaults to Strings Internal Hashcode
	 */
	public int getHash(String key){
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] byteArray = digest.digest(key.getBytes("UTF-8"));	
			ByteBuffer buffer = ByteBuffer.wrap(byteArray);
			return buffer.getInt(12) & 0x7fffffff ;
			
		} catch (Exception e) {
			e.printStackTrace();
			return key.hashCode();
		}
	}
}

class StringHashing implements HashFunction{
	@Override
	/*
	 * Default String Internal Hashcode
	 */
	public int getHash(String key){
		return key.hashCode() & 0x7fffffff;
	}
}

class MurmerHashing implements HashFunction{

	@Override
	public int getHash(String key) {
		return MurmurHash.hash32(key) ;//& 0x7fffffff;
	}
}
