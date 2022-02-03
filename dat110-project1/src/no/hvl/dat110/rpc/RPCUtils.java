package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = new byte [payload.length + 1];
		
		rpcmsg[0] = rpcid;
		
		for(int i = 0; i < payload.length; i++) {
			rpcmsg[i+1] = payload[i];
		}
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = new byte[rpcmsg.length - 1];
		
		for(int i = 0; i < payload.length; i++) {
			payload[i] = rpcmsg[i + 1];
		}
		
		return payload;
		
	}
	
	public static byte[] marshallString(String str) {
		
		return str.getBytes(StandardCharsets.UTF_8);
	}
	
	public static String unmarshallString(byte[] data) {
		
		return new String(data, StandardCharsets.UTF_8);
	}
	
	public static byte[] marshallVoid() {
		
		return new byte [0];
	}
	
	public static void unmarshallVoid(byte[] data) { }
	
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}
	
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}
	
	public static byte[] marshallInteger(int x) {
		
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.putInt(x);
		
		return buffer.array();
	}
	
	
	public static int unmarshallInteger(byte[] data) {
		
		ByteBuffer buffer = ByteBuffer.wrap(data);
		
		return buffer.getInt();
	}
}
