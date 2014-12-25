package com.yahoo.algos;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MyServer {

	/**
	 * Create ServerSocketChannel
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			if (serverChannel == null)
            {
				serverChannel = ServerSocketChannel.open();

                InetSocketAddress bindAddress = new InetSocketAddress("localhost", 4080);
                serverChannel.socket().bind(bindAddress, 100);
                serverChannel.socket().setReuseAddress(true);
//                SocketChannel channel = serverChannel.accept();
//                accepted(channel);
            }
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private void accepted(SocketChannel channel) throws IOException
    {
        channel.configureBlocking(false);
        Socket socket = channel.socket();
//        _manager.accept(channel);
    }
}
