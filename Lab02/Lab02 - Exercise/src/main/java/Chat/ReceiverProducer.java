package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverProducer implements Runnable {
    private final String id;
    private final Queue queue;
    private BufferedReader inputStream;
    private Socket socket;

    public ReceiverProducer(String id, Queue q, Socket s) { this.id = id; queue = q; socket = s; }

    public void run() {
        String msg;
        try {
            inputStream = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            while(true) {
                msg = inputStream.readLine();
                queue.put(msg);
//                System.out.println("ReceiverProducer put on the queue the received message");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
