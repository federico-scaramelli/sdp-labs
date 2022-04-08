package theatre;

import java.io.*;
import java.net.*;

public class MultiServer {
    public static void main(String argv[]) throws Exception {

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        Reservation reservation = new Reservation();

        try {
            ServerSocket welcomeSocket = new ServerSocket(6789);

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                // thread creation passing the established socket as arg
                ServerThreadTheatre theThread =
                        new ServerThreadTheatre(connectionSocket, reservation);

                // start of the thread
                theThread.start();
            }
        } catch(Exception e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }
}
