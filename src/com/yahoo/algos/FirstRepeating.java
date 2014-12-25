package com.yahoo.algos;

public class FirstRepeating {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []arr = {1,2,3,4,4,6,7};
		int xor=arr[0];
		for(int i=1;i<arr.length-1;i++){
			xor = arr[i]^xor;
			System.out.println(xor);
		}
	}

}
