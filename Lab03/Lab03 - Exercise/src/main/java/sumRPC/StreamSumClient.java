package sumRPC;

import com.example.grpc.RepeatedSumGrpc;
import com.example.grpc.StreamSumGrpc;
import com.example.grpc.Sum.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class StreamSumClient {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Trying to call repeated sum asynchronous method:\n");

        asynchronousStreamCall();

        System.out.println("\n...Done!");

    }
    //calling an asynchronous method based on stream
    public static void asynchronousStreamCall() throws InterruptedException {
        //plaintext channel on the address (ip/port) which offers the GreetingService service
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

        //creating an asynchronous stub on the channel
        StreamSumGrpc.StreamSumStub stub = StreamSumGrpc.newStub(channel);

        //the stub returns a stream to communicate with the server.
        //the argument is the stream of messages which are transmitted by the server.
        StreamObserver<StreamSumRequest> serverStream = stub.streamStreamSum(new StreamObserver<StreamSumResponse>() {
            //remember: all the methods here are CALLBACKS which are handled in an asynchronous manner.

            //we define what to do when a message from the server arrives (just print the message)
            public void onNext(StreamSumResponse serverResponse) {
                System.out.println("[FROM SERVER] " + serverResponse.getSum());
            }

            public void onError(Throwable throwable) {
            }

            public void onCompleted() {
            }
        });

        for(int i = 0; i < 10; i++){
            System.out.println("Request number " + i + " from the client.");
            //creating the HelloResponse object which will be provided as input to the RPC method
            serverStream.onNext(StreamSumRequest.newBuilder().setN1(10*i).setN2(5*i).build());
        }

        //you need this. otherwise the method will terminate before that answers from the server are received
        try {
            channel.awaitTermination(10, TimeUnit.SECONDS);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
