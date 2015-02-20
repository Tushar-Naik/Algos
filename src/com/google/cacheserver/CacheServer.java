package com.google.cacheserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.OperationNotSupportedException;

public class CacheServer {

	public static void main(final String[] args) {new Thread(){
		public void run(){
			try {
				new CacheServer().init(Integer.parseInt(args[0]));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}.start();
	}

	private void init(int port) throws IOException{
		
		final ExecutorService executor = Executors.newFixedThreadPool(1000);
		final ServerSocket serverSocket = new ServerSocket(port, 128);
		
		try {
			while(true){
				executor.submit(new ServerJob(serverSocket.accept()));
			}			
		} catch (IOException e) {
			e.printStackTrace();
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
				String line;
				//Serialzation type
				Serializer serializer = null;
				Operations.OPCODE opcode = null;
				String data = null;
				//Read input data
				while( (line = stream.readLine())!=null){
				//	System.out.println(line);
					if(line.equals("EOM")) break;
					if(line.startsWith("Type")){
						serializer = Utils.newSerializerFactory(line);
					}else if(line.startsWith("OP")){
						opcode = Utils.newOperationsFactory(line);
					}else if(line.startsWith("Data")){
						data = line.substring(5);
					}
				}
				
				
				//Deserialize
				CacheEntry entry = serializer.deserialize(data);
				
				//put cache
				CacheProvider provider = new BasicCache();
				Integer retVal=-1;
				if(opcode == Operations.OPCODE.PUT){
					provider.put(entry);
				}else if (opcode == Operations.OPCODE.GET){
					retVal = (provider.get(entry).getValue()!=null)? provider.get(entry).getValue(): -1;
				}
				System.out.println(opcode+" "+retVal);
				
				outStream =  new PrintStream(socket.getOutputStream());
				outStream.write(("Response: "+retVal.toString()).getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (OperationNotSupportedException e) {
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}finally{
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
