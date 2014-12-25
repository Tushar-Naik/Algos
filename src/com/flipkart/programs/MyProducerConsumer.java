package com.flipkart.programs;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.yahoo.algos.MyQueue;

public class MyProducerConsumer {
	public static volatile boolean stop = false;
	private static AtomicInteger value = new AtomicInteger(0);
	
	/**
	 * one way is just make the DS you use or queue shared access between prod/consumer by wait notify
	 * other way is implement like a Blocking queue and use it as ProducerConsumer.
	 * 
	 * LEARNING wait should always be in while loop. There are known spurious wake ups
	 * 
	 * first way done below
	 */
	public static void main(String[] args) {

		MyQueue<Integer> queue = new MyQueue<Integer>(100);
		MyProducerConsumer pc = new MyProducerConsumer();
		for (int i=0;i<10;i++){
			Producer prod = pc.new Producer(queue);
			new Thread(prod, "Producer-"+i).start();
		}
		Thread.currentThread().getState();
		for (int i=0;i<10;i++){
			Consumer cons = pc.new Consumer(queue);
			new Thread(cons, "Consumer-"+i).start();
		}
		try {
			Thread.sleep(10000);
			stop = true;
			System.out.println("STOP EVERYONE _______________________________");
			Thread.sleep(100);
			while(queue.peek()!=null){
				System.out.println(queue.dequeue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private class Producer implements Runnable{
		private final MyQueue<Integer> queue;
		private final Random rand = new Random();
		public Producer(MyQueue<Integer> queue){
			this.queue = queue;
		}
		@Override
		public void run(){
			while(true){
				if(MyProducerConsumer.stop) { System.out.println("Stop requested "+Thread.currentThread().getName()); break; }
				synchronized (queue) {
					//Block till full
					while(queue.isFull()){
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					int val = MyProducerConsumer.value.incrementAndGet(); //rand.nextInt(100);
					queue.enqueue(val);
					System.out.println("Producer-"+Thread.currentThread().getName()+" enqueud "+ val);
					queue.notifyAll();
					
				}
				try {Thread.sleep(1000); } catch (Exception e){}
			}
		}
	}
	
	private class Consumer implements Runnable{
		private final MyQueue<Integer> queue;
		public Consumer(MyQueue<Integer> queue){
			this.queue = queue;
		}
		@Override
		public void run(){
			while(true){
				if(MyProducerConsumer.stop) { System.out.println("Stop requested "+Thread.currentThread().getName()); break; }

				synchronized (queue) {
					//Block till new available
					while(queue.isEmpty()){
						try {
							queue.wait();
							System.out.println("Consumer-"+Thread.currentThread().getName()+" waiting");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					//Consume
					System.out.println("Consumer-"+Thread.currentThread().getName()+" dequeud "+ queue.dequeue());
					queue.notifyAll(); //Notify people waiting on queue full condition
				}
				try {Thread.sleep(1000); } catch (Exception e){}

			}
		}
	}

}
