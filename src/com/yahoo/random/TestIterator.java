package com.yahoo.random;

import java.math.BigInteger;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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
		
		//ConcurrentModfnEx
		Map<String, String> map = new HashMap<String, String>();
		map.put("a","b");map.put("b","b");map.put("c","b");map.put("d","b");
		try {
			for(Iterator<String> itr = map.keySet().iterator(); itr.hasNext();){
				System.out.println(itr.next());map.remove("d");
			}
			
		} catch (ConcurrentModificationException e) {
			System.out.println("if you remove while iterating you would get a CME failfast");
		}
		
		//Concurrent map doesnt thrown CME
		Map<String, String> chm = new ConcurrentHashMap<String, String>();
		chm.put("a","b");chm.put("b","b");chm.put("c","b");chm.put("d","b");
		for(Iterator<String> itr = chm.keySet().iterator(); itr.hasNext();){
			System.out.println(itr.next());chm.remove("d");
		}
		
		System.out.println("All fine no CME even when i removed an obj while iterating za");
		
		
		
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
