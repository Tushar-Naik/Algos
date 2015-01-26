package com.flipkart.programs;

public class MyBarrier {

	/*
	 * A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point. 
	 * CyclicBarriers are useful in programs involving a fixed sized party of threads that must occasionally wait for each other. 
	 * The barrier is called cyclic because it can be re-used after the waiting threads are released. 
	 */
	private volatile int count = 0;
	private int bound;
	Object LOCK = new  Object();
	MyBarrier(int bound) {
		this.bound = bound;
	}
	public int await() throws InterruptedException{
		int val = -1;
		synchronized (LOCK) {
			val = count++;
			while(count!=bound){
				System.out.println(Thread.currentThread().getName()+" Waiting");
				LOCK.wait();
			}
			LOCK.notifyAll();
		}
		return val;
	}
	public static void main(String[] args) throws InterruptedException {
		final int BOUND = 10;
		MyBarrier barrier = new MyBarrier(BOUND);
		for(int i=0; i < BOUND; i++){
			Thread.sleep(1000);
			new Thread(barrier.new MyThread(barrier)).start();
		}
	}
	
	private class MyThread implements Runnable{
		MyBarrier barrier;
		MyThread(MyBarrier barrier){
			this.barrier = barrier;
		}
		
		@Override
		public void run(){
			try {
				System.out.println(Thread.currentThread().getName()+" Created");

				int val = barrier.await();
				System.out.println(Thread.currentThread().getName()+" Started"+val);
				for(int i = 0;i<5 ;i++){
					Thread.sleep(1000);
				}
				System.out.println(Thread.currentThread().getName()+" Finished");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
