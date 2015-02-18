package com.flipkart.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/*
 * Design this better, what I have here is basic Client and multithreaded server with bounded 10 threads in pool to server
 */
public class MyServer {
	public static final int acceptQueueSize = 128;
	public static final AtomicInteger rps = new AtomicInteger(0);
	
	private void init() throws IOException{
		
		ExecutorService executor = Executors.newFixedThreadPool(100);
		final ServerSocket serverSocket = new ServerSocket(8081, acceptQueueSize);
		
		try {
			while(true){
				executor.submit(new ServerJob(serverSocket.accept()));
			}			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	

	public static void main(String[] args) throws InterruptedException {
		new Thread(){
			public void run(){
				try {
					new MyServer().init();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
		Thread.sleep(1000);
		new Thread(){
			public void run(){
				try {
					new Client().init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();

		
		new Thread(){
			public void run(){
				try {
					while(true){
						int old =rps.get(); 
						Thread.sleep(1000);
						System.out.println(rps.get());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		
	}
	
	private static class Client{
		public void init() throws InterruptedException{
			ExecutorService executor = Executors.newFixedThreadPool(10);
			while(true){
				executor.submit(new ClientJob());
				Thread.sleep(10);
			}
		}
	}
	
	private static class ClientJob implements Runnable{
		@Override
		public void run(){
			Socket socket = null;
			PrintWriter writer = null;
			try {
				socket = new Socket("localhost", 8081);
				writer = new PrintWriter( socket.getOutputStream());
				writer.write("Input to you : "+Thread.currentThread().getName());
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(writer!=null) {writer.flush(); writer.close();}
					if(socket!=null) {socket.close();}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		}
	}
	
	private static class ServerJob implements Runnable{
		final Socket socket;
		ServerJob(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run(){
			InputStream is = null;
			OutputStream outStream = null;
			try {
				is = socket.getInputStream();
				BufferedReader stream =  new  BufferedReader( new InputStreamReader(is));
				
				while(stream.ready()){
					//System.out.println(stream.readLine());
				}
				
				outStream =  new PrintStream(socket.getOutputStream());
				outStream.write(("Works: "+Thread.currentThread().getName()+"\n").getBytes());
				rps.incrementAndGet();
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				try {
					if(outStream!=null) {outStream.flush(); outStream.close();}
					if(is!=null) {is.close();}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		}
	}
}
