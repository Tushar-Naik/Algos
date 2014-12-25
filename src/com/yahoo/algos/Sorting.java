package com.yahoo.algos;

public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] array = {34,67,2,4,24,90,45,99};
		ShuffleArray.shuffle(array);
		insertionSort(array);
//		selectionSort(array);
		Common.print(array);
	}
	public static void selectionSort(int[] array){
		Common.print(array);
		for (int i=0;i < array.length-1;i++){
			
			int min = i;
			for (int j=i+1; j<array.length-1;j++){
				if(array[j] < array[min]) { min = j; }
			}
			Common.swap(array, i, min);
			Common.print(array);
		}
		Common.print(array);
	}
	
	public static void insertionSort(int[] array){
		for (int i = 0; i < array.length-1; i++) {
			for (int j=i; j > 0;j--){
				if (array[j] < array[j-1]){
					Common.swap(array, j, j-1);
					Common.print(array);
				}
			}
		}
//		System.out.println(i +" " + j);
	}
}
