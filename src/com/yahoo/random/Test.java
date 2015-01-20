package com.yahoo.random;

import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
