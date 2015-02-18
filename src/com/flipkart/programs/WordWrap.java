package com.flipkart.programs;

public class WordWrap {

	/**
	 * Given set of words and the width of each line output the justify
	 * input: aaa bb cc dddd
	 * output: 
	 * aaa
	 * bb cc
	 * dddd
	 * 
	 * This is Greedy solution O(N) We can have more optimized looking DP solution as well (but with more time complexity O(N^2))
	 */
	private void wrap(String[] words, int width){
		String line = words[0];
		int tl = words[0].length();
		
		for(int i = 1;i<words.length;i++){
			tl+=words[i].length() + 1;
			
			if(  (tl > width) ){//Edge case
				System.out.println(line); 
				line=words[i] ; tl=words[i].length(); //Reset editor line
				
			}else{
				line=line+" "+ words[i]; 
			}
		}
		System.out.println(line);
	}
	public static void main(String[] args) {
		String str = "Our Mock Interviews will be conducted in 'character' just like a real interview, and can focus on whatever topics you want. All our interviewers have worked for Microsoft, Google or Amazon, you know you'll get a true-to-life experience.";
		String str2 = "aaa bb cc dddd";
		new WordWrap().wrap(str2.split(" "), 5);
	}

}
