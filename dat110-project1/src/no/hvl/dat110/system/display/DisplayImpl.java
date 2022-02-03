package no.hvl.dat110.system.display;

import no.hvl.dat110.rpc.RPCRemoteImpl;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayImpl extends RPCRemoteImpl {

	public DisplayImpl(byte rpcid, RPCServer rpcserver) {
		super(rpcid,rpcserver);
	}
	
	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] params) {
		
		String s = RPCUtils.unmarshallString(params);

		System.out.println("DISPLAY:" + s);
		
		return RPCUtils.marshallVoid();		
	}
}
