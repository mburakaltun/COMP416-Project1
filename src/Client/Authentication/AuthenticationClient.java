package Client.Authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class AuthenticationClient {

    private Socket client;
    private BufferedReader clientIn;
    private BufferedReader keyboard;
    private PrintWriter clientOut;

    public AuthenticationClient(Socket client, BufferedReader clientIn, PrintWriter clientOut, BufferedReader keyboard) {
        this.client = client;
        this.clientIn = clientIn;
        this.clientOut = clientOut;
        this.keyboard = keyboard;
    }

    public void run() throws IOException {
        usernameAndPasswordResponse(client, clientIn, keyboard, clientOut);
        if (!client.isClosed()) {
            authenticationResponses(client, clientIn, keyboard, clientOut);
        }
    }

    public void usernameAndPasswordResponse(Socket s, BufferedReader clientIn, BufferedReader keyboard, PrintWriter clientOut) throws IOException {
        // Read "Enter your username: " from the server, read entered username from the user and send it to the server
        System.out.print(clientIn.readLine());
        String username = keyboard.readLine();
        clientOut.println(username);

        System.out.print(clientIn.readLine());
        String password = keyboard.readLine();
        clientOut.println(password);

        String message;
        String response;
        if ((message = clientIn.readLine()) != null) {
            System.out.println(message);
        }
        if ((response = clientIn.readLine()) != null) {
            if (response.compareTo("False") == 0) {
                s.close();
            }
            System.out.println("Now you will be answering authentication questions.");
        }

    }

    public void authenticationResponses(Socket s, BufferedReader clientIn, BufferedReader keyboard, PrintWriter clientOut) throws IOException {
        int totalNumberOfQuestions = clientIn.read();
        System.out.println("Total number of questions: " + totalNumberOfQuestions);
        int remainingNumberOfQuestions = totalNumberOfQuestions;
        String currentAnswer;
        String currentQuestion;
        String currentMessage;
        while (!s.isClosed() && remainingNumberOfQuestions > 0) {
            System.out.println("The remaining number of questions: " + remainingNumberOfQuestions);
            if ((currentQuestion = clientIn.readLine()) != null) {
                System.out.println(currentQuestion);
                remainingNumberOfQuestions--;
                currentAnswer = keyboard.readLine();
                clientOut.println(currentAnswer);
                currentMessage = clientIn.readLine();
                if (currentMessage.compareTo("Invalid answer.") == 0) {
                    System.out.println(currentMessage);
                    s.close();
                }
            }
        }
        if (!s.isClosed()) {
            String message = clientIn.readLine();
            System.out.println(message);
        }
    }
}
