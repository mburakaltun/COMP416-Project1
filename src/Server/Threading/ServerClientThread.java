package Server.Threading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Server.Authentication.AuthenticationServer;
import Server.WeatherAPI.WeatherService;

public class ServerClientThread extends Thread {
	Socket serverClient;
	int clientNo;
	String clientMessage = "", serverMessage = "";
	BufferedReader inStream;
	PrintWriter outStream;
	private AuthenticationServer authenticate;
	

	public ServerClientThread(Socket inSocket, int counter) {
		serverClient = inSocket;
		clientNo = counter;
	}

	public void run() {
		try {
			inStream = new BufferedReader(new InputStreamReader(serverClient.getInputStream()));
			outStream = new PrintWriter(serverClient.getOutputStream(), true);
			authenticate = new AuthenticationServer(serverClient, inStream, outStream);
			authenticate.execute();
			if(authenticate.isAuthenticationSuccessful()) {
				WeatherService weatherService = new WeatherService(serverClient, inStream, outStream);
				weatherService.execute();
			}
		} catch (Exception ex) {
			System.out.println("Streams cannot be created");
			ex.printStackTrace();
		} finally {
			System.out.println("Client no:" + clientNo + " has been disconnected! ");
		}
	}
}