package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    public static void main(String[] args) {
        try {
            // create the server socket (we create on this computer a new socket on port 9999)
            ServerSocket serverSocket = new ServerSocket(9999);
            // accept a client on this socket (blocks until connection is made)
            Socket clientSocket = serverSocket.accept();
            // the output (what we send as response)
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            // the input stream (what the clients send as request)
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                // when there is something on the input
                outputLine = inputLine + inputLine;
                // we send it to the output
                out.println(outputLine);
                System.out.println("Request:" + inputLine);
                if (outputLine.equals("Bye.Bye.")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
