package JSON;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class UniversityServer {

    public static void main(String argv[]) throws Exception {

        BufferedReader inFromClient;

        int portNumber = 6789;

        Gson gson = new Gson();

        try {
            ServerSocket welcomeSocket = new ServerSocket(portNumber);

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                inFromClient =
                        new BufferedReader(
                                new InputStreamReader(connectionSocket.getInputStream()));


                Student student = gson.fromJson(inFromClient.readLine(), Student.class);
                System.out.println(student.print());
            }
        } catch(Exception e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }

}
