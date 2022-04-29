package sumRPC;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class App {
    public static void main(String argv[]) throws Exception {

        //faccio partire il servizio sulla porta 8080
        try {

            Server server = ServerBuilder.forPort(8080)
                    .addService(new SimpleSumImpl())
                    .addService(new RepeatedSumImpl())
                    .addService(new StreamSumImpl())
                    .build();

            server.start();

            System.out.println("Server started!");

            server.awaitTermination();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

//    public void streamSimpleSum(SimpleSumRequest)
}
