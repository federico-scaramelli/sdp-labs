package Chat;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static void main(String argv[]) throws Exception {

        int portNumber = 6789;

        try {
            ServerSocket welcomeSocket = new ServerSocket(portNumber);

//            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                Queue q = new Queue();
                Queue q1 = new Queue();
                InputProducer p1 = new InputProducer("p1", q);
                SenderConsumer c1 = new SenderConsumer("c1", q, connectionSocket);
                ReceiverProducer p2 = new ReceiverProducer("p2", q1, connectionSocket);
                PrinterConsumer c2 = new PrinterConsumer("c2", q1);

                new Thread(p1).start();
                new Thread(c1).start();
                new Thread(p2).start();
                new Thread(c2).start();
//            }
        } catch(Exception e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }
}
