package Chat;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    //for each client and server implements a thread (producer1) that reads from the keyboard and put the msgf in ther queue1
    //another thread, consumer1, send the message to the server

    //another producer every time something arrives on the socket, put on another queue2.
    //the consumer2 reads the messages from the queue2 and print on the console

    //in the chat room case, the server needs to save the ids of the sockets connected to the server

    public static void main(String[] args) {
        int portNumber = 6789;

        try {
            Socket clientSocket = new Socket("127.0.0.1", portNumber);

            Queue q = new Queue();
            Queue q1 = new Queue();
            InputProducer p1 = new InputProducer("p1", q);
            SenderConsumer c1 = new SenderConsumer("c1", q, clientSocket);
            ReceiverProducer p2 = new ReceiverProducer("p2", q1, clientSocket);
            PrinterConsumer c2 = new PrinterConsumer("c2", q1);
            new Thread(p1).start();
            new Thread(c1).start();
            new Thread(p2).start();
            new Thread(c2).start();
        } catch(Exception e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }
}
