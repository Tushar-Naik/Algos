package com.yahoo.random;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CollectionClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = addToSet();
		try {
			set.add("Test");
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
	}

	private static Set<String> addToSet() {
		Set<String> set = new HashSet<String>();
		set.add("Apple");set.add("Umbrella");set.add("Mango");
		
		return Collections.unmodifiableSet(set);  //Collections gives static factory to lot of Collection classes. Also this one is imutable ref
		//this returns UnmodifiableSet<T> --> UnModifiableCollection which just wraps all your add/remove calls to throw UnsupportedOperationException
		// and allows the get calls
	}

}
