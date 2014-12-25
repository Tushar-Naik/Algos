package com.yahoo.algos;

import java.util.Random;

public class ShuffleArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {26,3,67,2,77,33,4};
		shuffle(array);
	}
	public static void shuffle(int[] array) {
		int size = array.length-1;
		Random rand = new Random();
		Common.print(array, "before Shuffle");
		for(int i = size;i>1;i--){ 
			// NOTE its 1 and not 0, since when you do nextInt(1) it gives 0, nextInt(n) gives random no between 0 and n exclusive
			Common.swap(array, i, rand.nextInt(i));
		}
		Common.print(array, "after Shuffle");
	}
	
}
