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
	
	public static void printMatrix(int[][] matrix){
		int rows = matrix.length ;
		int cols = (rows==0)?0:matrix[0].length;
		
		for (int i=0;i<=rows-1;i++){
			for (int j=0;j<=cols-1;j++){
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
