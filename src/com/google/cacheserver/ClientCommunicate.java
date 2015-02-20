package com.google.cacheserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientCommunicate {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static void main(String[] args) {
		new ClientCommunicate().sendData("localhost:"+args[0], args[1], Integer.parseInt(args[2]));
	}

	
	//Use Consistent Hashing connect to one of the server
	//Send a operation
	
	private void sendData(String host, String key, int val){
		
		Socket socket = null;
		PrintWriter writer = null;
		try {
			Operations.OPCODE opcode = (val==-1)?Operations.OPCODE.GET:Operations.OPCODE.PUT;

			String hostName = host.split(":")[0];
			int port = Integer.parseInt(host.split(":")[1]);
			socket = new Socket(hostName, port);
			writer = new PrintWriter( socket.getOutputStream());
			writer.write(serializeData( new CacheEntry(key, val), opcode ));
			writer.flush();
	         BufferedReader in =
	                 new BufferedReader(
	                     new InputStreamReader(socket.getInputStream()));
	         
	         System.out.println(in.readLine());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(writer!=null) {writer.flush(); writer.close();}
				if(socket!=null) {socket.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private String serializeData(CacheEntry entry, Operations.OPCODE opcode, Serializer serializer) throws IOException{
		StringBuffer buffer = new StringBuffer();
		buffer.append("OP:"+opcode + LINE_SEPARATOR );
		buffer.append("Type:"+serializer.getType() + LINE_SEPARATOR);
		buffer.append("Data:"+serializer.serialize(entry)+ LINE_SEPARATOR);
		buffer.append("EOM"+ LINE_SEPARATOR);
		return buffer.toString();
	}
	private String serializeData(CacheEntry entry, Operations.OPCODE opcode) throws IOException{
		return serializeData(entry, opcode, new BasicSerializer());
	}
}
