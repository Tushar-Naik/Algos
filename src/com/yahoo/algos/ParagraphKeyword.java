package com.yahoo.algos;

import java.util.HashSet;

public class ParagraphKeyword {

	/**
	 * Given a review paragraph and keywords, find minimum length snippet from paragraph which contains all keywords in any order.
	 * Extended question 3 if there are millions of review, what preprocessing step would you do.
	 * 
	 * http://www.geeksforgeeks.org/flipkart-interview-set-2-sde-2/
	 */
	public static void main(String[] args) {
		//maxoicmrroucencmoccurrence
		//m o c
		String para= "maxoicmrroucencmoccurrence";
		HashSet<String> set = new HashSet<String>();
		set.add("m");set.add("o");set.add("c");
		int start=0 , end=0;
		
		for(int i=0;i<=para.length()-1; i++){
			char c = para.charAt(i);
			if(start==0 && set.contains(c)){
				start = i;
			}else{
				
			}
			
		}
	}

}
