package com.yahoo.algos;

import java.util.ArrayList;
import java.util.List;

public class FindNPrime {

	/**
	 * @param args
	 */
	public void printFirstNPrimes(int n){
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		int count=1, i = 2;
		
		while(count<=n){
			if(isPrime(++i)) {
				count++; 
				list.add(i);
			}
		}
		System.out.println(list);
	}
	private boolean isPrime(int n){
		for(int i=2;i<=n-1;i++){
			if(n%i==0) return false;
		}
		return true;
		
	}
	
	//not working
	public void printFirstNPrimesEasy(int max){
		int counter=0;
		for (int i = 2; i <= max; i++) {
		    counter = 0;
		    for (int n = 2; n < i; n++) {
		        if (i % n == 0) {
		            counter++;
		        }
		    }
		    if (counter == 0) {
		        System.out.println(i);
		    }
		}
	}
	
	public static void main(String[] args) {
		new FindNPrime().printFirstNPrimes(26);
		new FindNPrime().printFirstNPrimesEasy(26);
	}

}
