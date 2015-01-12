package com.flipkart.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * (1) client call MyExecutor.newFixedThreadPool(noOfThread) and 
 *    (1a) MyExecutor creates noOfThreads and all threads get queue instance and waits on BlockingQueue take or poll(timeout)
 *    (1b) return to client MyExcutor instanc
 * (2) Clients can create MyWorker i/f which has work() command method
 *    (2a) Client create worker instance
 *    (2b) client call myExecutorInstance.sumbit(worker)
 * (3) MyExecutor submit just adds offer worker on the BlockingQueue
 * (4) Client can call shutdoownNow on myExecutorInstance which calls stopNow (volatile var in thread)
 *     or Clients can send a Poison worker message which stops all workers
 *         
 * Thread.currentThread().interrupt(); 
 *      sets interrupt flag if thread is not in wait/block, 
 *      if thread on wait/block it would throw interrupted exception which we should catch and do Thread.currentThread().interrupt() to set flag again
 *      
 *Implementation of MyThread
 * (Approach 1) Have a volatile stopNow and have while(true && !stopNow) 
 *              Now a thread blocked on take would keep waiting options 
 *              (a) do poll and timeout poll with timeout gives null worker. check if(q.isEmpty & stopNow) break and if(worker!null) worker.work
 *              (b) Do Thread.currentThread.interrupt() to set interrupted status when stopNow and catch IntEx and do Th.curTh.inter() again while loop cheks isInterruoted 
 *              
 *              
 * (Approach 2) MyThread extends Thread (Runnable NO) and now Executor.shutdownNow calls .interrupt on all threads.
 *              MyThread can have   while(!Thread.isInterrputed())  
 *              Ones on take/poll would throw interruptedEx catch and do Thread.currentThread().interrupt() to set interrupted status flag  
 *      
 */
public class MyThreadPool {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyExecutor exector = new MyExecutor();
		exector.fixedThreadPool(20);
		for(int i=0;i<10;i++){
			MyWorker worker = new MyWorkerImpl("Work-"+i);
			exector.submit(worker);
		}
		Thread.sleep(5000);
		exector.shutdownNow();
		System.out.println("All Work finished");
	}
}
	
class MyExecutor{
	BlockingQueue<MyWorker> queue = new LinkedBlockingQueue<MyWorker>();
	List<MyThread> list = new ArrayList<MyThread>();
	
	public void fixedThreadPool(int noOfThreads){
		for (int i =0;i< noOfThreads ; i ++){
			MyThread myThread = new MyThread(queue);
			Thread thread = new Thread(myThread);
			thread.setName("Thread-"+i);
			thread.start();
			list.add(myThread);
		}
	}
	
	public void submit(MyWorker worker){
		queue.offer(worker);
	}
	
	public void shutdownNow(){
		System.out.println(Thread.currentThread().getName()+" Stopping all Threads");
		for(MyThread thread: list){
			thread.stopThread(); //Or other way is to Poison Threads or send a poison message for all.
		}
	}
}

class MyThread extends Thread{
	private volatile boolean stopThread = false;
	BlockingQueue<MyWorker> queue ;
	public MyThread(BlockingQueue<MyWorker> queue){
		this.queue = queue;
	}
	public void run(){
		//while(true && !stopThread){
		while(!Thread.currentThread().isInterrupted() ){
		//while(true){
			try {
				if(stopThread){
					System.out.println(Thread.currentThread().getName()+" Stopped"); Thread.currentThread().interrupt(); // break;
				}
				//MyWorker worker =  queue.take(); //Blocking call 
				MyWorker worker =  queue.poll(1000, TimeUnit.MILLISECONDS); //Blocking call if no obj in 1000 ms come out with null worker output
				if(queue.isEmpty() && stopThread){
					throw new InterruptedException();
				}
				if(worker!=null){
					System.out.println(Thread.currentThread().getName()+" Running "+worker.getName());
					worker.work();
				}
				
			}catch (InterruptedException ie ){
				System.out.println(Thread.currentThread().getName()+" Thread Interrupted Stopped"); Thread.currentThread().interrupt(); //break; 
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopThread(){
		stopThread = true;
		
	}
}

interface MyWorker{
	public abstract void work();
	public abstract String getName();
}

class MyWorkerImpl implements MyWorker{
	String name;
	public MyWorkerImpl(String name) {
		this.name = name;
	}
	 public void work(){
		 try {
			for(int i =0;i<10;i++){
				System.out.println(Thread.currentThread().getName()+" counting "+i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	 }
	 public String getName() {
		return name;
	}
}