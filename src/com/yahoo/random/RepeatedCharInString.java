package com.yahoo.random;

public class RepeatedCharInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str = "repeatedcharinstring";
		String str = "norepat";
		int checked =0;
		for(int i =0;i<str.length() -1 ; i++){
			int val = str.charAt(i) - 'a'; //val has to be unique if char unique in string
			if ( (checked & (1<<val))  > 0){ // has to be zero if val was unique since that bit position would be empty
				System.out.println("repeated char: "+str.charAt(i)+" at pos:"+i); 
			}
			checked |= (1<< val); //occupy the bit position of char, so character b which is 98 or val =1 would be 1<<1 or 10 or second bit from right
		}
		
		
	}
	

	/*replace blank with %20 */
	public static void ReplaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') { 
				spaceCount++;
			}
		}
		
		newLength = length + spaceCount * 2; str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			
				if (str[i] == ' ') {
					str[newLength - 1] = '0'; 
					str[newLength - 2] = '2'; 
					str[newLength - 3] = '%'; 
					newLength = newLength - 3;
				} else {
					
					str[newLength - 1] = str[i];
					newLength = newLength - 1; 
					}
		} 
	}

}
