package com.flipkart.programs;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	/**
	 * @param args
	 */
	public static volatile boolean stop = false;
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
		ProducerConsumer pc = new ProducerConsumer();
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
			Thread.sleep(7000);
			stop = true;
			System.out.println("STOP EVERYONE _______________________________");
			Thread.sleep(100);
			while(queue.peek()!=null){
				System.out.println(queue.poll());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


private class Producer implements Runnable{

	private final BlockingQueue<Integer> queue;
	Random rand = new Random();
	public Producer(BlockingQueue<Integer> queue) {
	   this.queue = queue;
	}
	@Override
	public void run() {
		while (true){
			try {
				if(ProducerConsumer.stop) { System.out.println("Stop requested "+Thread.currentThread().getName()); break; }
				Integer r = rand.nextInt(100);
				System.out.println("Producer Adding "+r);
				queue.offer(r);
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

private class Consumer implements Runnable{

	private final BlockingQueue<Integer> queue;
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue= queue;
	}
	@Override
	public void run() {
		while(true){
			try {
				if(ProducerConsumer.stop) { System.out.println("Stop requested "+Thread.currentThread().getName()); break; }
				Integer element = queue.take();
				System.out.println(Thread.currentThread().getName()+ "-Taken "+ element );
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

}




