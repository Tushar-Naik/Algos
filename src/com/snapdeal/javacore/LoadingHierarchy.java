package com.snapdeal.javacore;

public class LoadingHierarchy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Child c = new Child();
		/*
			Static Parent
			Static Child
			Instance Block Parent
			Parent constructor
			Instance Block Child
			Child constructor
		 */
		c = new Child();
		/*
		 * Instance Block Parent
			Parent constructor
			Instance Block Child
			Child constructor
		 */
	}

}

class Parent{
	{
		System.out.println("Instance Block Parent");
	}
	static{
		System.out.println("Static Parent");
	}
	Parent(){
		System.out.println("Parent constructor");
	}
}

class Child extends Parent{
	{
		System.out.println("Instance Block Child");
	}
	static{
		System.out.println("Static Child");
	}
	Child(){
		//compiler will add a call to super
		System.out.println("Child constructor");
	}
}

