package no.hvl.dat110.messaging;


import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;

public class MessagingClient {
	
	private String server;
	private int port;
	
	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	// connect to messaging server
	public Connection connect () {
			
		try {
			Socket socket = new Socket(server, port);
			return new Connection(socket);
		} catch (IOException e) {
			System.out.println("Messaging client: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
