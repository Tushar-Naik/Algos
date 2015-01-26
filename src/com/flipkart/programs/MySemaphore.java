package com.flipkart.programs;

public class MySemaphore {

	/**
	 * A counting semaphore. Conceptually, a semaphore maintains a set of permits. 
	 * Each acquire() blocks if necessary until a permit is available, and then takes it. 
	 * Each release() adds a permit, potentially releasing a blocking acquirer. 
	 * However, no actual permit objects are used; the Semaphore just keeps a count of the number available and acts accordingly. 
	 */
	
	volatile private int bound = 0;
	private final Object LOCK = new Object();
	
	public MySemaphore(int bound){
		this.bound = bound;
	}
	
	public void acquire() throws InterruptedException {
		synchronized (LOCK) {
			while(bound==0){
				System.out.println(Thread.currentThread().getName()+" waiting");
				LOCK.wait();
			}
			System.out.println(Thread.currentThread().getName()+"-------------- acquired");
			bound--;
			LOCK.notifyAll();
		}
	}
	
	public void release(){
		synchronized (LOCK) {
			bound++;
			LOCK.notifyAll();
		}
	}
	
	public static void main(String[] args) {
		MySemaphore sem = new MySemaphore(3);
		for(int i =0;i<10;i++){
			new Thread(sem.new MyThread(sem)).start();
		}
		System.out.println(Thread.currentThread().getName()+" FINISHED");
	}
	
	private class MyThread implements Runnable{
		MySemaphore sem;
		MyThread(MySemaphore sem){
			this.sem = sem;
		}
		
		public void run(){
			try{
				sem.acquire();
				for(int i =0;i<5;i++){
					System.out.println(Thread.currentThread().getName()+" sleeping");
					Thread.sleep(1000);
				}
				
			}catch(Exception e){
			}finally{
				sem.release();
			}
		}
	}

}
