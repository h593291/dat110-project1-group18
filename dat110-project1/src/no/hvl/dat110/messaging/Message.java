package no.hvl.dat110.messaging;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		
		if(data == null || data.length > 127)
			throw new IllegalArgumentException("Data cannot be null and must be less than 128 bytes");

		this.data = data;
	}

	public byte[] getData() {
		return this.data; 
	}

}
