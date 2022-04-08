package theatre;

import java.io.*;
import java.net.*;

public class ServerThreadTheatre extends Thread {

    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;
    private Reservation r;

    public ServerThreadTheatre(Socket s, Reservation r) {
        this.r = r;
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

        try {
            synchronized (r) {
                String s = inFromClient.readLine();
                if (r.getFreeSeats() > 0) {
                    System.out.println("There are seats available. Waiting for book.");
                    r.reserveSeat();
                    Thread.sleep(2000);

                    System.out.println("Seat booked. Remaining available seats: " + r.getFreeSeats());
                    outToClient.writeBytes("Yes" + '\n');
                } else {
                    System.out.println("There is not any available seat.");
                    outToClient.writeBytes("No" + '\n');
                }
            }

            connectionSocket.close();
        } catch (IOException e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
