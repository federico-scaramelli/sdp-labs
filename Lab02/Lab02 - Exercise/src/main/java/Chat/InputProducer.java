package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class InputProducer implements Runnable {

    private final String id;
    private final Queue queue;

    public InputProducer(String id, Queue q) { this.id = id; queue = q; }

    public void run() {
        String msg;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
//            System.out.println("Insert a message: ");
            try {
                msg = inFromUser.readLine();
                queue.put(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
