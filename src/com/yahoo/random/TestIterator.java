package com.yahoo.random;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestIterator {

	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("Apple");set.add("Umbrella");set.add("Mango");
		MyTestSet<String> test = new TestIterator().new MyTestSet<String>(set);
		for(String magic : test){//Note since MyTestSet implements Iterable
			System.out.println(magic);
		}
		
		//BigInteger
		
		BigInteger big = new BigInteger("12345");
		BigInteger big2 = new BigInteger("12345");
		big2.add(big);
		
	}

	private class MyTestSet<T> implements Iterable<T>{
		private final Set<T> set ;
		public MyTestSet(Set<T> set){
			this.set = set;
			
		}
		public Iterator<T> iterator (){
			return set.iterator();
		}
		
	}
}
