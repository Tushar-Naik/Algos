package com.flipkart.programs;

import java.util.Arrays;

public class MyBigInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(equalAdd(new int[]{1,2,3,4,5,6}, new int[]{1,2,3,4,5,6}));
		System.out.println(add(new int[]{1,2,3,4,5,6}, new int[]{8,0,5}));

   }

   public static String add(int[] a1, int[] a2){


           return null;
   }

   public static String equalAdd(int[] a1, int[] a2){
           int length = Math.max(a1.length, a2.length);
           int[] result = new int[length];
           boolean overFlow = false;
           for (int i = length-1; i >= 0; i--){
                   //check array index bound
                   int sumIndex = a1[i] + a2[i] +result[i];
                   if(sumIndex > 9){
                           if (i-1 >=0) result[i-1] +=1;
                           else{overFlow = true;}
                   }
                   result[i] =  sumIndex % 10;
           }
           return Arrays.toString(result);
   }
}
