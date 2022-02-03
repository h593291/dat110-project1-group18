package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCLocalStub;
import no.hvl.dat110.rpc.RPCUtils;

public class SensorStub extends RPCLocalStub {

	private byte RPCIDREAD = 1;

	public SensorStub(RPCClient rpcclient) {
		super(rpcclient);
	}

	public int read() {
		
		byte[] params = RPCUtils.marshallVoid();

		byte[] result = rpcclient.call(RPCIDREAD, params);

		return RPCUtils.unmarshallInteger(result);
	}

}
