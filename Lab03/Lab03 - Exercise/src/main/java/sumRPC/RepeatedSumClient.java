package sumRPC;

import com.example.grpc.RepeatedSumGrpc;
import com.example.grpc.SimpleSumGrpc;
import com.example.grpc.Sum.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class RepeatedSumClient {
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
        RepeatedSumGrpc.RepeatedSumStub stub = RepeatedSumGrpc.newStub(channel);

        //creating the HelloResponse object which will be provided as input to the RPC method
        RepeatedSumRequest request = RepeatedSumRequest.newBuilder().setN(10).setT(5).build();

        //calling the RPC method. since it is asynchronous, we need to define handlers
        stub.streamRepeatedSum(request, new StreamObserver<RepeatedSumResponse>() {

            //this hanlder takes care of each item received in the stream
            public void onNext(RepeatedSumResponse repeatedSumResponse) {

                //each item is just printed
                System.out.println("The received async sum is: " + repeatedSumResponse.getSum());

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
