package com.yahoo.random;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.BitSet;

import com.yahoo.algos.MurmurHash;

public class ByteBufferTest {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		bitSets();
	}

	private static void bitSets() throws NoSuchAlgorithmException{
		String key = "testing";
		BitSet bits = new BitSet(32);
		BitSet bits2 = new BitSet(32);bits2.set(95);bits2.set(2); System.out.println(bits2);
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] barray = md.digest(key.getBytes());
		
		int murHash = MurmurHash.hash32(key) & 0x7fffffff;
		int md5Hash = upperFourBytes(barray) & 0x7fffffff;
		printByteArray(barray);
		printByteArray(Arrays.copyOf(barray, 5));
		
		System.out.println( murHash+" "+md5Hash);
		//BLOOM FILTER
		System.out.println(md5Hash%32);
		System.out.println(murHash%32);
		bits.set(md5Hash%32);
		bits.set(murHash%32);
		
		System.out.println(bits);
	}
	
	private static int upperFourBytes(byte[] barray) {
		ByteBuffer bb = ByteBuffer.wrap(barray);
		return bb.getInt();
	}

	private static void printByteArray(byte[] b){
		for(int bb = 0 ; bb<b.length-1;bb++)
		 System.out.print(b[bb]+" ");
		System.out.println();
//		System.out.println("first Four");
	}
}
