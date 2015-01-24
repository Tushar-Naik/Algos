package com.yahoo.random;

public class Inheritance {

	public void entity(Parent p){
		System.out.println("Called with Parent");
	}
	public void entity(Child c){
		System.out.println("Called with Child");
	}
	
	public static void main(String[] args) {
		long [] one = new long[2];
		one = new long[3]; // ok with diff size 3
		//one = new int[3]; //NOT Ok
		short s = 1; byte b = 1; char ch =1;
		int [] two = {s,b,ch}; //OK 
		
		Inheritance in = new Inheritance();
		Parent p = new Parent();
		Child c = new Child();
		Parent pc = new Child();
		p.eat();
		c.eat();
		pc.eat(); // Object type is Child so Child Method
		c.eat("something");
		//Overiding is based on run time Object Type
		//		pc.parentSplEat(); Not Possible Obj type is Child
		//		pc.eat("something"); //Not Possible Obj type is Child
		
		//Overloading is based on Reference type
		in.entity(c);
		in.entity(p);
		in.entity(pc); // Reference type is Parent
	}
}

class Parent{
	protected int x =1; // ONLY my kids and same package can access.
	public void eat(){
		System.out.println("Parent Eat");
	}
	public void parentSplEat(){
		System.out.println("parentSplEat");
	}
}
class Child extends Parent{
	@Override
	public void eat(){
		System.out.println("Child Eat");
	}
	
	public void eat(String what){
		System.out.println("Child eat "+what);
		parentSplEat();
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		int val = c.x;
		
		Parent p = new Parent();
		val = p.x;
	}
}