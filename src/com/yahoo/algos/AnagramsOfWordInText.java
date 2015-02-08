package com.yahoo.algos;

/*
 * All anagrams that match a String para
 */
public class AnagramsOfWordInText {
	static int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 
        19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 
        73, 79, 83, 89, 97, 101, 103 };
	
	public static void main(String[] args) {      
		final char[] text = "abcxaaabbbccyaxbcayaaaxycab".toCharArray();     
        char[] abc = new char[]{'a','b','c'};       
        int match = val(abc);                   
        for (int i = 0; i < text.length - 2; i++) {
            char[] _123 = new char[]{text[i],text[i+1],text[i+2]};          
            if(val(_123)==match){
                System.out.println(new String(_123) );      
            }
        }
    }
	static int p(char c) {
        return primes[c - 'a'];
    }   
    static int val(char[] cs) {
        return  p(cs[0])*(int)cs[0] + p(cs[1])*(int)cs[1] + p(cs[2])*(int)cs[2];        
    }

}
