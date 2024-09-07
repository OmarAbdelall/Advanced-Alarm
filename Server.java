package HomeWork;

import java.io.DataInputStream;



import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{ 
// attributes.
	 public String y;
	

	public void Server() {
		
		
	
	try {
		    ServerSocket serversocket = new ServerSocket(7000);
		    System.out.println("Wating for client");
		    Socket socket = serversocket.accept();
		    OutputStream os = socket.getOutputStream();
			DataOutputStream oos = new DataOutputStream(os);
			
			// send the student list
			oos.writeUTF ( "Server side:Now you are able to\n set the Timer.");
			
			InputStream in = socket.getInputStream();
			DataInputStream din = new DataInputStream(in);
			
			y =din.readUTF();
		   //   System.out.println(y);
		    os.close();
		    oos.close();
		    in.close();
		    din.close();
			serversocket.close();
		  
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	}

	
	
public static void main(String[] args) {
Server server =	new Server();
	server.start();
}	

@Override
public void run() {
	
	
	try {
		//Thread.currentThread().sleep(100);
		 Server();
		
	}catch(Exception e) {
		
	}
}
	
}

	
	
	


