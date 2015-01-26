package com.flipkart.programs;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.BitSet;
import java.util.UUID;

import com.yahoo.algos.MurmurHash;

public class BloomFilter {

	/**
	 * A Bloom filter is a data structure designed to tell you, rapidly and memory-efficiently, whether an element is present in a set.
	 * The price paid for this efficiency is that a Bloom filter is a probabilistic data structure: 
	 * it tells us that the element either definitely is not in the set or may be in the set. 
	 * 
	 * http://billmill.org/bloomfilter-tutorial/
	 */
	
	private final int BITS = 32;
	private BitSet bitSet = new BitSet(BITS); 

	public void put(String key){
		try {
			//Calculate 2 Hashes
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] barray = md.digest(key.getBytes());
			int md5hash = upperFourBytes(barray) & 0x7fffffff;
			int murmHash = MurmurHash.hash32(key) & 0x7fffffff;
			
			System.out.println(murmHash % BITS + " " +md5hash % BITS);
			bitSet.set(murmHash % BITS);bitSet.set(md5hash % BITS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * COntains may be
	 */
	public boolean get(String key){
		
		try {
			//Calculate 2 Hashes
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] barray = md.digest(key.getBytes());
			int md5hash = upperFourBytes(barray) & 0x7fffffff;
			int murmHash = MurmurHash.hash32(key) & 0x7fffffff;
			
			return bitSet.get(murmHash % BITS) && bitSet.get(md5hash % BITS); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private static int upperFourBytes(byte[] barray) {
		ByteBuffer bb = ByteBuffer.wrap(barray);
		return bb.getInt();
	}
	
	public static void main(String[] args) {
		BloomFilter bf = new BloomFilter();
		bf.put("Flipkart");
		bf.put("Amazon");
		System.out.println(bf.bitSet);
		System.out.println(bf.get("FLipkart"));
		System.out.println(bf.get("Flipkart"));
		System.out.println(bf.get("Amazon"));
		
		//Test Ramdom Strings which arent there and yet match the Bloom Filter
		for(int i = 0;i<500;i++){
			String uuid = UUID.randomUUID().toString();
			if(bf.get(uuid)){
				System.out.println("Matched for "+uuid);
			}
		}
	}

}
