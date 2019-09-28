package com.github.lofi.client;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.core.client.EntryPoint;

public class AppEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// Do nothing, just to load the Java classes
		document.body.appendChild(document.createElement("div"))
				.appendChild(document.createTextNode("Hello from Java!"));
	}
}
