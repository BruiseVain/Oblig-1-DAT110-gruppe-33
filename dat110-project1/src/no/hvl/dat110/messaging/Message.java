package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {
	
	private final int MSG_SIZE = 128;
	private byte[] payload;
	

	public Message(byte[] payload) {
		 // TODO: check for length within boundary
		if(payload.length <= MSG_SIZE - 1) {
			this.payload = payload;
		}else {
			throw new IllegalArgumentException("The payload size is too large");
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = null;
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		encoded = new byte[MSG_SIZE];
		int sizeOfMsg = payload.length;
		encoded[0] = (byte) sizeOfMsg;
		
		for(int i = 0; i < payload.length; i++) {
			encoded[i+1] = payload[i];
		}
		
		/**
		if (true)
		   throw new UnsupportedOperationException(TODO.method());
		*/
		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
		
		int length = received[0];
		payload = new byte[length];
		
		for(int i = 0; i < length; i++) {
			payload[i] = received[i+1];
		}
		
		
	}
}
