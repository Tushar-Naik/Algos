package com.yahoo.algos;

public class ReverseString {

	public static void reverse(char[] charStr, int start , int end){
		while(end>=start){
			swap(charStr, start, end);
			start++; end--;
		}
		System.out.println(new String(charStr));
	}
	
	private static void swap(char[] str, int i, int j){
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
	}
	
	public static void leftRotate(String str, int k){
		char[] charArray = str.toCharArray();
		int len = str.length() - 1 ;
		reverse(charArray, 0, k-1); 
		reverse(charArray, k, len);
		reverse(charArray, 0, len);
	}
	
	public static void rightRotate(String str, int k){
		char[] charArray = str.toCharArray();
		int len = str.length() - 1 ;
		reverse(charArray, 0, len);
		reverse(charArray, 0, k-1); 
		reverse(charArray, k, len);
	}
	
	public static void main(String[] args) {
		leftRotate("happy", 2);
		System.out.println();
		rightRotate("happy", 2);
		
	
	}

}
