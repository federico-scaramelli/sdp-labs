package Chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SenderConsumer implements Runnable {

    private final Queue queue;
    private final String id;
    Socket socket;
    DataOutputStream outputStream;


    public SenderConsumer(String id, Queue q, Socket s) {
        this.id = id;
        queue = q;
        socket = s;
    }

    public void run() {
        try {
            outputStream =
                    new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                consume(queue.take());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume(String message) throws IOException {
//        System.out.println("Consumer " + id + " invia al server: " + message);
        outputStream.writeBytes(message + '\n');
    }
}
