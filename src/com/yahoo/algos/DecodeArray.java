package com.yahoo.algos;

/*
 * Decode and output all possible options of an array where we have mapping say
 * a -1 b-2....
 * So 121 could be AU or ABA or LA 
 */

public class DecodeArray {
	private final String[] ALPHA = {"", "a", "b","c", "d","e", "f","g", "h", "i", "j","k", "l","m", "n","o", "p","q", "r", "s","t", "u","v", "w", "x","y", "z"};
	
	private void call(String s, String output){
		if(s.length()==0){
			System.out.println(output);
			return;
		}
			
		//Divide in 1
		if(s.length()>=1){
			String newOutput =  output + ALPHA[Integer.parseInt(s.substring(0,1))];
			call(s.substring(1), newOutput);
		}
		if (s.length()>=2 && Integer.parseInt(s.substring(0,2))<=26){
			//Divide in 2
			String newOutput =  output + ALPHA[Integer.parseInt(s.substring(0,2))];
			call( s.substring(2), newOutput);
		}
	}
	
	public static void main(String[] args) {
		new DecodeArray().call("2154", "");
	}
	
}
