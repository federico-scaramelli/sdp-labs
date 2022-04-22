package Chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PrinterConsumer implements Runnable {
    private final Queue queue;
    private final String id;


    public PrinterConsumer(String id, Queue q) {
        this.id = id;
        queue = q;
    }

    public void run() {
        while (true) {
            try {
                consume(queue.take());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume(String message) throws IOException {
//        System.out.println("Consumer " + id + " riceve dal server: " + message);
        System.out.println(message);
    }

}
