package com.yahoo.algos;

public class PermutationOfWord {

	/**
	 * Find all permutations of a word
	 */
	static int count=0;
	public static void permutations(String suffix, String word){
		int n = word.length();
		if(n==0) {
			System.out.println(suffix);count++;return;
		}
			
		for(int i=0;i<n;i++){
			permutations(suffix + word.charAt(i), 
					     word.substring(0,i) + word.substring(i+1));
		}
	}
	
	public static void main(String[] args) {
		permutations("", "ABCDE");
		System.out.println("ABCD".substring(2, 2));//NOTE THIS picks nothing. So starting from index i take j-i
		System.out.println("Total Permutations: "+count);
	}
}
