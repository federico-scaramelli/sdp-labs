package concurrent;

import java.io.*;
import java.net.*;

public class MultiServer {
    public static void main(String argv[]) throws Exception {

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Insert the port number: ");
        String portNumber = inFromUser.readLine();

        try {
            ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(portNumber));

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                // thread creation passing the established socket as arg
                ServerThread theThread =
                        new ServerThread(connectionSocket);

                // start of the thread
                theThread.start();
            }
        } catch(Exception e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }
}
