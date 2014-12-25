package com.yahoo.algos;

import java.util.Arrays;

public class KthLargest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {33,4,77,67,35,2,26,29};
		System.out.println(quickSelect(array, 4)); //4th largest
//		Sorting.insertionSort(array);
		Arrays.sort(array);
		Common.print(array);

	}

	private static int quickSelect(int[] array, int kLargest ) {
		//partition 
		ShuffleArray.shuffle(array);
		int lo =0; int hi = array.length-1;
		while (lo<=hi){
			int j = partition(array,lo,hi);
			System.out.println("partition "+j);
			if(kLargest < j){
				//my kth largest is in left side 
				hi = j -1;
			}else if (kLargest > j){
				// my kth largest is on right side
				lo = j+1;
			}else {
				return array[kLargest];
			}
		}

		return -1;	
	}
	
	//find j such that all elements left of j are less than j and 
	//all elements right of j are more than j
	private static int partition(int[] array, int lo, int hi){
		int i = lo; int j = hi+1; int partition = array[0];
		while(i<=j){
			while( array[++i] < partition ){
				if(i==hi) break;
			}
			while( array[--j] > partition ){
				if(j==lo) break;
			}
			if(i>=j) break;
			Common.swap(array, i, j);
			Common.print(array);
		}
		return j;
	}

}
