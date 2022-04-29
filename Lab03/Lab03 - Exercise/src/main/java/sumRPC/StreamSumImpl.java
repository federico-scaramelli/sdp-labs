package sumRPC;

import com.example.grpc.StreamSumGrpc;
import com.example.grpc.Sum.*;
import io.grpc.stub.StreamObserver;

public class StreamSumImpl extends StreamSumGrpc.StreamSumImplBase {
    @Override
    public StreamObserver<StreamSumRequest> streamStreamSum(StreamObserver<StreamSumResponse> responseObserver) {
        //it returns the stream that will be used by the clients to send messages. The client will write on this stream
        return new StreamObserver<StreamSumRequest>() {
            //receiving a message from the client
            public void onNext(StreamSumRequest clientRequest) {
                int sum = clientRequest.getN1() + clientRequest.getN2();

                // sending the response to the client
                System.out.println("Sending the response to the client...\n");
                responseObserver.onNext(StreamSumResponse.newBuilder().setSum(sum).build());
            }

            public void onError(Throwable throwable) {
            }

            public void onCompleted() {
            }
        };
    }
}
