package com.yahoo.random;

public class Swap {

	/**
	 * @param args
	 */
	private static void swap1(int x, int y){
		System.out.println("Before "+x +" "+y);
		x = x+y;
		y = x-y;
		x = x-y;
		System.out.println("After "+x +" "+y);
	}
	
	private static void swap2(int x, int y){
		System.out.println("Before "+x +" "+y);
		x = x+y;
		y = x-y;
		x = x-y;
		System.out.println("After "+x +" "+y);
	}
	
	public static void main(String[] args) {
		int x = 2;
		int y = 5;
		swap1(x, y);
		swap2(x, y);
	}

}
