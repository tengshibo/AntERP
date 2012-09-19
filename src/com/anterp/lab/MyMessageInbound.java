package com.anterp.lab;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

public class MyMessageInbound extends MessageInbound {

	@Override
	protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void onTextMessage(CharBuffer charBuffer) throws IOException {
		WsOutbound outbound = this.getWsOutbound();
		System.out.println("onTextMessage:" + charBuffer);
		outbound.writeTextMessage(CharBuffer.wrap("Receive your message:"
				+ charBuffer));
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		super.onOpen(outbound);
	}

	@Override
	protected void onClose(int status) {
		System.out.println("onClose status:" + status);
		super.onClose(status);
	}
}
