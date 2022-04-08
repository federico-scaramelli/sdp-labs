package Iterative;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String argv[]) throws Exception {
        String portNumber;
        String address;
        String n1, n2, sum;
        DataOutputStream outToServer;
        BufferedReader inFromServer;

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insert the address: ");
        address = inFromUser.readLine();
        System.out.println("Insert the port number: ");
        portNumber = inFromUser.readLine();

        try {
            Socket clientSocket = new Socket(address, Integer.parseInt(portNumber));

            outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());

            inFromServer =
                    new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Select the first number to sum: ");
            n1 = inFromUser.readLine();
            outToServer.writeBytes(n1 + '\n');

            System.out.println("Select the second number to sum: ");
            n2 = inFromUser.readLine();
            outToServer.writeBytes(n2+ '\n');


            sum = inFromServer.readLine();

            String output = n1 + " + " + n2 + " = " + sum;
            System.out.println(output);

            clientSocket.close();
        } catch (Exception e){
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }

}
