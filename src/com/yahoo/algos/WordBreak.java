package com.yahoo.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordBreak {

	/**
	 * Input:  ilikesamsung
		Output: Yes
		The string can be segmented as "i like samsung" or "i like sam sung". Given dictionary of valid words
	 */
	List<String> dictionery = Arrays.asList(new String[]{"i", "like", "samsung", "sam", "good", "luck", "buddy", "love"});
	List<String> result;
	private boolean wordBreak(String str){
		//System.out.println(str);
		if(str.length()==0) return true;
		for(int i=1;i<=str.length();i++){
			if(dictionery.contains(str.substring(0,i))  && wordBreak(str.substring(i))){
				result.add(str.substring(0,i));
				return true;
			}
		}
		return false;
	}
	
	private boolean wordBreak2(String str, String output){
		//System.out.println(str);
		if(str.length()==0) return true;
		
		for(int i=1;i<=str.length();i++){
			String prefix = str.substring(0,i);
			if(dictionery.contains(prefix)){
				//End case
				if(str.length()==i){
					System.out.println(output+" "+prefix );
				}
				wordBreak2(str.substring(i), output+ " " +prefix);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		WordBreak breakw = new WordBreak();
		breakw.result = new ArrayList<String>();
		breakw.wordBreak("goodluckbuddy");
		Collections.reverse(breakw.result);
		System.out.println(breakw.result);
		
		System.out.println(new WordBreak().wordBreak2("goodluckbuddy",""));
	}

}
