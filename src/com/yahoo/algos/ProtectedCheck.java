package com.yahoo.algos;

import com.yahoo.random.Test;
/*
 * If you have a variable or method in your class that you don’t want clients of your class directly accessing, declare it protected. 
 * Classes that extend your class will still be able to use it even if they are not part of the same package. 
 * The default package accessibility has slightly more restricted visibility.
 */
public class ProtectedCheck extends Test{

	public static void main(String[] args) {
		new ProtectedCheck().test();
	}
	
	private void test() {
		//Checking protected
		Test test = new Test();
//	    int val = test.protectedInt;//CANT SEE
		test.publicMethod(); // cant see protectedMethod		
	}

	@Override //Can override protected Method
	//private void protectedMethod(){ Scope cant be less
//	protected void protectedMethod() throws Throwable{  Cant throw more
	protected void protectedMethod() throws NullPointerException{
		System.out.println("protectedMethod");
	}
	
	
}
