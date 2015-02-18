package com.flipkart.programs;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SelectorServer {
	private void init2() throws IOException{
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.socket().bind( new InetSocketAddress("localhost", 8081));
		
		while(true){
			executor.submit(new ChannelJob(channel.accept()));
		}
	}
	
	private static class ChannelJob implements Runnable{
		final SocketChannel socket;
		ChannelJob(SocketChannel socket){
			this.socket = socket;
		}
		
		@Override
		public void run(){
//			socket.
		}
	}
	
}
