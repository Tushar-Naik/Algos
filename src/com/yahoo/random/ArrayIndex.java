package com.yahoo.random;

public class ArrayIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//int[] a = {d,a,c,f,f,b,};
		int [] a = new int[5];  //here we can take 5 int values. Note local Array default init to 0
		//a[5]=1; // throws java.lang.ArrayIndexOutOfBoundsException: 5
		a[4]=1; //ok
		String s = "dsdd";
		System.out.println(s.length()); //gives 4 
		System.out.println(a.length);//gives 5
		//In a for loop over Array use  a.length but < and not <=
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}
		
		//In a loop over String chars also
		System.out.println();
		for(int i=0;i<s.length();i++){
			System.out.print(s.charAt(i));
		}
		
	}

}
