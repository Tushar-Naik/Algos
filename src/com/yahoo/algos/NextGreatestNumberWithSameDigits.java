package com.yahoo.algos;

import java.util.Random;

public class NextGreatestNumberWithSameDigits {

	/**
	Find next greater number with same set of digits
	
	Given a number n, find the smallest number that has same set of digits as n and is greater than n. 
	If x is the greatest possible number with its set of digits, then print “not possible”.
	 */
	
	private void findGreatest(char[] val){
		//Numbers in ascending order
		 if(isAsc(val)){
			 swap(val, val.length-1, val.length-2);
			 print(val);
			 return;
		 }
		//Numbers in descending order
		 if(isDesc(val)){
			 System.out.println("Not Possible");
			 return;
		 }
//		 218765
		 //Optimization
		if(val[val.length-1] > val[val.length-2] ) {
			swap(val, val.length-1, val.length-2);
			return;
		}
		
		for(int i=val.length-1; i>=0;i--){
			if(val[i]>val[i-1]){
				copy(val, i-1); return;
			}
		}
	}
	
	private void copy(char[] val, int index) {
		char[] val2 = new char[val.length];
		//copy from 0 - (index-1)
		for(int i=0;i<=index-1;i++){
			val2[i]=val[i];
		}
		//put index
		val2[index] = val[val.length-1];
		
		//put index+1
		val2[index+1] = val[index];
		
		//rotate and keep rest
		int rest = val.length-index;
		for(int a =2, i = index+2; i< index+rest; i++,a++){
			val2[i] = val[val.length-a]; 
		}
		print(val2);
	}

	private void swap(char[] val, int i, int j){
		char t = val[i];
		val[i] = val[j];
		val[j] = t;
	}
	
	private void print(char[] val){
		for(int i =0;i<=val.length-1;i++){
			System.out.print(val[i]);
		}
		System.out.println();
	}
	
	private boolean isAsc(char[] val){
		for(int i=0; i < val.length-1;i++){
			if(val[i]>val[i+1]){
				return false;
			}
		}
		return true;
	}
	private boolean isDesc(char[] val){
		for(int i=0; i < val.length-1;i++){
			if(val[i]<val[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new Random().nextInt(3446677));
//		String s = "4321";
//		String s = "218765";
//		String s = "534976";
		String s = "1028876";
		System.out.println("input \n"+s);
		NextGreatestNumberWithSameDigits digit = new NextGreatestNumberWithSameDigits();
		digit.findGreatest(s.toCharArray());
	}
}
