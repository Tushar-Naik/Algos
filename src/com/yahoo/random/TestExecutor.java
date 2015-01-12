package com.yahoo.random;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutor {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		TestExecutor testExecutor = new TestExecutor();
		ExecutorService exe = Executors.newFixedThreadPool(2);
		for (int i =0;i<10;i++){
			exe.submit(testExecutor.new MyThread());
		}
		Thread.sleep(1000);
		exe.shutdownNow();
	}
	
	private class MyThread implements Runnable{
		public void run(){
			try {
				for (int i=0;i<Integer.MAX_VALUE;i++){
					Thread.sleep(10000);
					System.out.println(Thread.currentThread().getName()+ " up");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Thread Interrupted "+Thread.currentThread().getName());
				//e.printStackTrace();
			}
		}
	}
}
