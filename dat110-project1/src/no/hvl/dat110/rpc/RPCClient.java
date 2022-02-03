package no.hvl.dat110.rpc;

import no.hvl.dat110.messaging.Connection;
import no.hvl.dat110.messaging.Message;
import no.hvl.dat110.messaging.MessagingClient;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {

		msgclient = new MessagingClient(server,port);
	}
	
	// TODO Constructor connection == null
	public void connect() {
		if(connection != null) return;
		connection = msgclient.connect();
	}
	
	public void disconnect() {
		if(connection == null) return;
		connection.close();
		connection = null;
	}
	
	public byte[] call(byte rpcid, byte[] params) {
		
		byte[] rpcmsg = RPCUtils.encapsulate(rpcid, params);
		Message message = new Message(rpcmsg);
		
		connection.send(message);
		Message response = connection.receive();
		
		return RPCUtils.decapsulate(response.getData());
	}
}
