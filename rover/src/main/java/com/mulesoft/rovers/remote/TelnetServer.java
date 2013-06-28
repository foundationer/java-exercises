package com.mulesoft.rovers.remote;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TelnetServer {

	private final ServerSocket socket;

	public TelnetServer(final int port) throws IOException {
		socket = new ServerSocket(port);
	}

	public Socket accept() throws IOException {
		return socket.accept();
	}

	public void disconnect() throws IOException {
		socket.close();
	}
}
