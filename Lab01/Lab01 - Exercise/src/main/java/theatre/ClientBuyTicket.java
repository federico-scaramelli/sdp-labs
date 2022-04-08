package theatre;

import java.io.*;
import java.net.*;

public class ClientBuyTicket {
    public static void main(String argv[]) throws Exception {
        DataOutputStream outToServer;
        BufferedReader inFromServer;

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        try {
            Socket clientSocket = new Socket("localhost", 6789);

            outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());

            inFromServer =
                    new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Press Enter to buy a ticket...");
            String s = inFromUser.readLine();
            outToServer.writeBytes("" + '\n');
            while(true) {
                String s1 = inFromServer.readLine();
                if(s1 == null) break;
                if (s1.equals("No")) {
                    System.out.println("There is not any available seat. Sorry for the inconvenience.");
                } else if (s1.equals("Yes")) {
                    System.out.println("Seat booked.");
                }
            }

//            clientSocket.close();
        } catch (Exception e){
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }
}
