package sumRPC;

import com.example.grpc.SimpleSumGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.example.grpc.SimpleSumGrpc.*;
import com.example.grpc.Sum.*;

import java.util.concurrent.TimeUnit;

public class SimpleSumClient {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Trying to call greeting synchronous method:\n");

        synchronousCall();

        System.out.println("\n...Done!");

        System.out.println("--------------");

        System.out.println("Now calling streamGreeting asynchronous method:\n");

        asynchronousStreamCall();

        System.out.println("\n...Done!");

    }

    //calling a synchronous rpc operation
    public static void synchronousCall(){

        //plaintext channel on the address (ip/port) which offers the GreetingService service
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

        //creating a blocking stub on the channel
        SimpleSumBlockingStub stub = SimpleSumGrpc.newBlockingStub(channel);

        //creating the HelloResponse object which will be provided as input to the RPC method
        SimpleSumRequest request = SimpleSumRequest.newBuilder().setN1(10).setN2(20).build();

        //calling the method. it returns an instance of HelloResponse
        SimpleSumResponse response = stub.streamSimpleSum(request);

        //printing the answer
        System.out.println("The received sync sum is: " + response.getSum());

        //closing the channel
        channel.shutdown();

    }

    //calling an asynchronous method based on stream
    public static void asynchronousStreamCall() throws InterruptedException {
        //plaintext channel on the address (ip/port) which offers the GreetingService service
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

        //creating an asynchronous stub on the channel
        SimpleSumStub stub = SimpleSumGrpc.newStub(channel);

        //creating the HelloResponse object which will be provided as input to the RPC method
        SimpleSumRequest request = SimpleSumRequest.newBuilder().setN1(10).setN2(20).build();

        //calling the RPC method. since it is asynchronous, we need to define handlers
        stub.streamSimpleSum(request, new StreamObserver<SimpleSumResponse>() {

            //this hanlder takes care of each item received in the stream
            public void onNext(SimpleSumResponse simpleSumResponse) {

                //each item is just printed
                System.out.println("The received async sum is: " + simpleSumResponse.getSum());

            }

            //if there are some errors, this method will be called
            public void onError(Throwable throwable) {

                System.out.println("Error! " + throwable.getMessage());

            }

            //when the stream is completed (the server called "onCompleted") just close the channel
            public void onCompleted() {

                channel.shutdownNow();

            }
        });

        //you need this. otherwise the method will terminate before that answers from the server are received
        channel.awaitTermination(10, TimeUnit.SECONDS);
    }
}
