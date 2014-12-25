package com.yahoo.algos;

import java.util.NoSuchElementException;


/*
 * Circular queue using array
 * Not Thread safe
 */
public class MyQueue<E> {
	private static final int DEFAULT_CAPACITY=50;
	private int capacity;
	private final E[] arrayQ;
	private int size;
	int frontPtr = 0;
	int rearPtr = 0;
	
	@SuppressWarnings("unchecked")
	public MyQueue(int capacity){
		arrayQ = (E[]) new Object[capacity];
		this.capacity = capacity;
	}
	
	public MyQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	public void enqueue(E element){
		if(isFull()){
			throw new StackOverflowError();
		}
		arrayQ[frontPtr] = element;
		frontPtr = (frontPtr + 1)  % capacity;
		// return (++i == items.length)? 0 : i; Array Blocking Queue
		size ++;
	}
	
	public E dequeue(){
		if (isEmpty()){
			throw new NoSuchElementException();
			
		}
		
		E item = arrayQ[rearPtr];
		arrayQ[rearPtr] =  null;
		rearPtr = (rearPtr + 1) % capacity;
		size --;
		return item;
	}
	
	public E peek(){
		return arrayQ[rearPtr];
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public boolean isFull(){
		return (size==capacity);
	}
	
	public static void main(String[] args) {
		MyQueue<String> queue = new MyQueue<String>(3);
		queue.enqueue("Shubh");
		queue.enqueue("is");
		queue.enqueue("good");
		System.out.println("peek----"+queue.peek());
		System.out.println(queue.dequeue());
		queue.enqueue("ShubhII");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		try {
			System.out.println(queue.dequeue());
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException came Q empty" );
		}
		queue.enqueue("Good");
		queue.enqueue("Works");
		
	}

}
