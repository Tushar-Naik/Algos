package com.yahoo.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllSubstringOfString {

	/**
	 * Why O(N^2) ?? has to be O(N)
	 * Java String internally maintains char[] hence the substring call is a linear time and space call
	 */
	
	private void subStrings(String str){
		List<String> sList = new ArrayList<String>();
		
		for(int i=0;i<=str.length();i++){
			for(int j=i+1;j<=str.length();j++){
				//System.out.println(str.substring(i, j));
				sList.add(str.substring(i,j));
			}
		}
		Collections.sort(sList);
		System.out.println(sList);
	}
	
	private void subString2(String str){
		int length = str.length();
		String[] subStrings = new String[str.length()];
		for(int i=0;i<length;i++){
			subStrings[i] = str.substring(i, length);
			System.out.println(str.substring(i, length));
		}
		
		System.out.println("all Subs Sorted----------");
		Arrays.sort(subStrings);
		for(int i=0;i<subStrings.length;i++){
			System.out.println(subStrings[i]);
		}
	}
	
	public static void main(String[] args) {
		new AllSubstringOfString().subStrings("aasasatb");
		System.out.println("----------");
		new AllSubstringOfString().subString2("aasasatb");
	}

}
