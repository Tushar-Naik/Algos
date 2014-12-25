package com.yahoo.algos;

import java.util.EmptyStackException;

public class Stack <Item>{
	public static int CAPACITY = 10;
	private Item [] array;
	int top = -1;
	int size = 0;
	
	public Stack() {
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		array = (Item []) new Object[capacity];
		this.CAPACITY = capacity;
	}
	
	public void push(Item element){
		if(top==CAPACITY-1){
			throw new StackOverflowError(); // or resize by double and copy old to new. So fetch is amortized O(N)
		}
		array[++top] = element;
	}
	
	public Item pop(){
		if(top<0){
			throw new EmptyStackException(); // or half when its quarter full
		}
//		return array[top--];//NOT GOOD
		Item ret = array[top];
		array[top--] = null;
		return ret;  
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public Item[] getArray(){
		return array;
	}
	
	public static void main(String[] args) {
		Stack st = new Stack();
		st.process();
	}
	private void process() {
		Stack<String> st = new Stack<String>();
		st.push("Shubh");st.push("is");st.push("good");
		print(st.getArray());
		st.pop();
		st.push("best");
		print(st.getArray());
		// POP EVERY THING
		try {
			st.pop();st.pop();
			System.out.println("\n"+st.pop()+"n");
			st.pop(); //NO SUCH ELEMENT
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//PUSH beyond capacity
		try {
			for(int i=0;i<10;i++)
				st.push(""+i);
			st.push("test");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		print(st.getArray());
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			builder.append( array[i]+" ");
		}
		return builder.toString();
	}
	
	private void print(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print( array[i]+" ");
		}
	System.out.println();
	}
	
	private class Node{
		String item;
		Node next;
		public Node(String item, Node next) {
			super();
			this.item = item;
			this.next = next;
		}
		public Node(String item) {
			this.item = item;
		}
	}
}
