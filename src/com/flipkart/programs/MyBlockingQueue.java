package com.flipkart.programs;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue{
	public static volatile boolean stop = false;
	private static AtomicInteger value = new AtomicInteger(0);

	
	public static void main(String[] args) {
		MyBlockingQueue pc = new MyBlockingQueue();
		MyBlockingQueueImpl<Integer> queue = pc.new MyBlockingQueueImpl<Integer>(100);

		for (int i=0;i<10;i++){
			Consumer cons = pc.new Consumer(queue);
			new Thread(cons, "Consumer-"+i).start();
		}
		for (int i=0;i<10;i++){
			Producer prod = pc.new Producer(queue);
			new Thread(prod, "Producer-"+i).start();
		}
		Thread.currentThread().getState();
		try {
			Thread.sleep(7000);
			stop = true;
			System.out.println("STOP EVERYONE _______________________________");
			Thread.sleep(100);
			while(queue.peek()!=null){
				System.out.println(queue.take());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	class MyBlockingQueueImpl<E> {//implements BlockingQueue<E>{
		private final ReentrantLock qLock = new ReentrantLock();
	    private final Condition condition; 

		private static final int DEFAULT_CAPACITY=50;
		private final int capacity;
		private final E[] arrayQ; 
		private int frontPtr = 0;
		private int rearPtr = 0;
		private int size = 0;
		
		@SuppressWarnings("unchecked")
		public MyBlockingQueueImpl(int capacity){
			this.capacity = capacity;
			arrayQ = (E[]) new Object[capacity];
			condition = qLock.newCondition();
		}
		
		public MyBlockingQueueImpl(){
			this(DEFAULT_CAPACITY);
		}
	
/*		public boolean offer(E e) throws InterruptedException {
			synchronized (arrayQ) {
				while(isFull()){
					arrayQ.wait();
				}
				arrayQ[frontPtr] = e;
				frontPtr = (frontPtr + 1) % capacity;
				size ++;
				arrayQ.notifyAll();
				return true;
			}
		}
		
		public E take() throws InterruptedException {
			synchronized (arrayQ) {
				while(isEmpty()){
					arrayQ.wait();
				}
				E item = arrayQ[rearPtr];
				arrayQ[rearPtr] = null;
				rearPtr = (rearPtr + 1) % capacity;
				size--;
				arrayQ.notifyAll();
				return item;
			}
		} */
		
		public boolean offer(E e) throws InterruptedException {
			qLock.lock();
			try {
				while(isFull()){
					condition.await();
				}
				arrayQ[frontPtr] = e;
				frontPtr = (frontPtr + 1) % capacity;
				size ++;
				condition.signalAll();
			} finally {
				qLock.unlock();
			}
			return true;
		}
		
		public E take() throws InterruptedException {
			qLock.lock();
			try {
				while(isEmpty()){
					condition.await();
				}
				E item = arrayQ[rearPtr];
				arrayQ[rearPtr] = null;
				rearPtr = (rearPtr + 1) % capacity;
				size--;
				condition.signalAll();
				return item;
				
			} finally {
				qLock.unlock();
			}
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
	}

	private class Producer implements Runnable{

		private final MyBlockingQueueImpl<Integer> queue;
		public Producer(MyBlockingQueueImpl<Integer> queue) {
		   this.queue = queue;
		}
		@Override
		public void run() {
			while (true){
				try {
					if(MyBlockingQueue.stop) { System.out.println("Stop requested "+Thread.currentThread().getName()); break; }
					Integer r = MyBlockingQueue.value.incrementAndGet();
					System.out.println("Producer Adding "+r);
					queue.offer(r);
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class Consumer implements Runnable{

		private final MyBlockingQueueImpl<Integer> queue;
		public Consumer(MyBlockingQueueImpl<Integer> queue) {
			this.queue= queue;
		}
		@Override
		public void run() {
			while(true){
				try {
					if(MyBlockingQueue.stop) { System.out.println("Stop requested "+Thread.currentThread().getName()); break; }
					Integer element = queue.take();
					System.out.println(Thread.currentThread().getName()+ "-Taken "+ element );
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}