package sumRPC;

import com.example.grpc.RepeatedSumGrpc;
import com.example.grpc.Sum;
import io.grpc.stub.StreamObserver;

public class RepeatedSumImpl extends RepeatedSumGrpc.RepeatedSumImplBase {
    @Override
    public void streamRepeatedSum(Sum.RepeatedSumRequest request, StreamObserver<Sum.RepeatedSumResponse> responseObserver) {
        System.out.println("Repeated sum requested from the client: \n" +
                request.getN() + " x " + request.getT() + "times");

        int sum = 0;
        for (int i = 0; i < request.getT(); i++) {
            sum += request.getN();
            Sum.RepeatedSumResponse response = Sum.RepeatedSumResponse.newBuilder().setSum(sum).build();
            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }
}
