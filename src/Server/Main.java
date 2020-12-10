package Server;

import Server.Authentication.AuthenticationServer;

import Server.WeatherInfo.Weather;
import Server.Threading.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    private static int PORT = 9999;

    public static void main(String[] args) throws InterruptedException {
    	try {
			ServerSocket server = new ServerSocket(9999);
			int counter = 0;
			System.out.println("The server is ready and waiting for connection...");
			while (true) {
				Socket serverClient = server.accept();
				serverClient.setSoTimeout(20000);
				counter++;
				System.out.println(" >> " + "Client No:" + counter + " started!");
				ServerClientThread sct = new ServerClientThread(serverClient, counter); 
				sct.start();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}