package sumRPC;

import com.example.grpc.SimpleSumGrpc.SimpleSumImplBase;
import com.example.grpc.Sum.*;
import io.grpc.stub.StreamObserver;

public class SimpleSumImpl extends SimpleSumImplBase {
    @Override
    public void streamSimpleSum(SimpleSumRequest request, StreamObserver<SimpleSumResponse> responseObserver) {
        System.out.println("Sum requested from the client: \n" + request.getN2() + " + " + request.getN2());

        SimpleSumResponse response = SimpleSumResponse.newBuilder().setSum(request.getN1() + request.getN2()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
