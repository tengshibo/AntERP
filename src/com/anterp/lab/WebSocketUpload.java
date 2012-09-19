package com.anterp.lab;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

public class WebSocketUpload extends WebSocketServlet {

	private static final long serialVersionUID = 6788608581777884082L;

	@Override
	protected StreamInbound createWebSocketInbound(String arg0,
			HttpServletRequest arg1) {
		// TODO Auto-generated method stub
		return new MyMessageInbound();
	}

}
