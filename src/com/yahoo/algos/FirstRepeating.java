package com.yahoo.algos;

public class FirstRepeating {

	/**
	 *  The conclusion is that if we XOR a number with itself odd number of times we get 0, 
	 *  otherwise if we XOR even number of times then we get the number itself. -
	 *   See more at: http://www.ardendertat.com/2011/11/29/programming-interview-questions-18-find-even-occurring-element/#sthash.4kj2pSjJ.dpuf
	 */
	public static void main(String[] args) {
		//INCORRECT CODE DONT USE
		
		int []arr2 = {1,1,1,4,4,6,7};
		int xor2=0;
		for(int i=0;i<arr2.length-1;i++){
 			xor2 = arr2[i]^xor2;
			System.out.println(xor2);
		}
		
		int []arr = {1,2,3,4,4,6,7};
		int xor=arr[0];
		for(int i=1;i<arr.length-1;i++){
			xor = arr[i]^xor;
			System.out.println(xor);
		}
	}

}
