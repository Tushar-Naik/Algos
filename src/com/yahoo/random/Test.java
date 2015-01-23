package com.yahoo.random;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public class Test {

	/**
	 * @param args
	 */
	private static class Tuple{
		
		String jobName;
		int deadline;
		public Tuple(String jobName, int deadline) {
			this.jobName = jobName;
			this.deadline = deadline;
		}
		@Override
		public String toString() {
			return "Tuple [jobName=" + jobName + ", deadline=" + deadline + "]";
		}
		
	}
	public static void main(String[] args) {
		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		};
		TreeMap<Integer, Tuple> map = new TreeMap<Integer, Tuple>(comp);
		map.put(100, new Tuple("a", 2));
		map.put(19, new Tuple("b", 1));
		map.put(27, new Tuple("c", 2));
		map.put(25, new Tuple("d", 1));
		map.put(15, new Tuple("e", 3));
		
		System.out.println(map);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(86400000);
		//pattern
		ArrayList<String>list = new ArrayList<String>();
		list.add("a");list.add("u");list.add("m");
		String[] ar = list.toArray(new String[0]);
		
		tryNested();
		String chars = "agoodboy";
		int checked =0;
		for (int i =0;i<chars.length()-1;i++){
			int c = chars.charAt(i) - 'a';
			System.out.println(c);
			if( (checked & (1 << c))>0 ){
				System.out.println("repeated");
			}
			checked|=(1<<c);
		}
	}

	private static void tryNested() {
		for(int i =0;i<10;i++){
			for(int j =0 ; j <10 ; j++){
				if (j==0) break;
				System.out.println("never");
			}
		}
	}

}
