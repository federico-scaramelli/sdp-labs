package Iterative;

import java.io.*;
import java.net.*;

public class IterativeServer {
    public static void main(String argv[]) throws Exception {
        String portNumber;
        BufferedReader inFromClient;
        DataOutputStream outToClient;

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Insert the port number: ");
        portNumber = inFromUser.readLine();
        try {
            System.out.println(Integer.parseInt(portNumber));

            ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(portNumber));

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                InetAddress addr = connectionSocket.getInetAddress();
                System.out.println("New connection accepted:\nAddress: "
                        + addr.getHostAddress() + "\nPort: " + connectionSocket.getPort());


                inFromClient =
                        new BufferedReader(
                                new InputStreamReader(connectionSocket.getInputStream()));

                outToClient =
                        new DataOutputStream((connectionSocket.getOutputStream()));

                int n1 = Integer.parseInt(inFromClient.readLine());
                System.out.println("n1 received: " + n1);
                int n2 = Integer.parseInt(inFromClient.readLine());
                System.out.println("n2 received: " + n2);

                int sum = n1 + n2;

                outToClient.writeBytes(Integer.toString(sum) + '\n');
                connectionSocket.close();

            }
        } catch (Exception e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }

}
