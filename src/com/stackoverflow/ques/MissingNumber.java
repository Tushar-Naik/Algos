package com.stackoverflow.ques;

public class MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] orig = {1,2,3,4,5,6,8,9,10};
		int[] copy = {1,2,3,4,5,6,7,8,9,10};
		int origXor=0, copyXor =0;
		for (int i = 0; i < orig.length; i++) {
			origXor = origXor ^ orig[i];
		}
		for (int i = 0; i < copy.length; i++) {
			copyXor = copyXor ^ copy[i];
		}
		
		System.out.println(origXor +" "+copyXor);
		System.out.println((origXor ^ copyXor));
		
	}
}
