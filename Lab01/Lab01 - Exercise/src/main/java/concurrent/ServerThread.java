package concurrent;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    public ServerThread(Socket s) {
        connectionSocket = s;
        try {
            inFromClient =
                    new BufferedReader(
                            new InputStreamReader(connectionSocket.getInputStream()));
            outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

            InetAddress addr = connectionSocket.getInetAddress();
            System.out.println("New connection accepted:\nAddress: "
                    + addr.getHostAddress() + "\nPort: " + connectionSocket.getPort());
        }catch (Exception e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }

    public void run() {
        int n1, n2, sum;

        try {
            n1 = Integer.parseInt(inFromClient.readLine());
            System.out.println("n1 received: " + n1);
            n2 = Integer.parseInt(inFromClient.readLine());
            System.out.println("n2 received: " + n2);

            sum = n1 + n2;

            outToClient.writeBytes(Integer.toString(sum) + '\n');
            connectionSocket.close();
        } catch (IOException e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }
}
