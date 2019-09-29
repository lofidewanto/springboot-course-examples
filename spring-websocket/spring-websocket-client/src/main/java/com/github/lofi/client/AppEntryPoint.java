package com.github.lofi.client;

import static elemental2.dom.DomGlobal.document;

import com.example.demo.api.Constants;
import com.google.gwt.core.client.EntryPoint;

import elemental2.dom.WebSocket;

public class AppEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// Do nothing, just to load the Java classes

		WebSocket webSocket = new WebSocket("ws://localhost:9090/server" + Constants.GS_GUIDE_WEBSOCKET);

		boolean send = webSocket.send("Test");

		document.body.appendChild(document.createElement("div"))
				.appendChild(document.createTextNode("Send to Socket: " + send));
	}
}
