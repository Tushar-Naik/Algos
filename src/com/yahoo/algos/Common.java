package com.yahoo.algos;

import com.yahoo.random.Test;

public class Common {

	/**
	 * @param args
	 */
	
	public static void print(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void print(int[] arr, String before){
		System.out.print(before+" ");
		print(arr);
	}
	
	public static void swap (int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
