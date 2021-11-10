package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExample {
    public static void main(String[] args) {
        Socket echoSocket = null;
        try {
            // connect to socket on localhost the name of the computer port 9999
            echoSocket = new Socket("localhost", 9999);
            // open output stream (the request we send)
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            // open input stream (the response we get)
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            // standard input that is what we send as request
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println(userInput);
                // the response from the server
                System.out.println("Response: " + in.readLine());
                if (userInput.equals("Bye.")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
