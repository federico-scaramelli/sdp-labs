package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: Sum.proto")
public final class SimpleSumGrpc {

  private SimpleSumGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.SimpleSum";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Sum.SimpleSumRequest,
      com.example.grpc.Sum.SimpleSumResponse> getStreamSimpleSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamSimpleSum",
      requestType = com.example.grpc.Sum.SimpleSumRequest.class,
      responseType = com.example.grpc.Sum.SimpleSumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Sum.SimpleSumRequest,
      com.example.grpc.Sum.SimpleSumResponse> getStreamSimpleSumMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Sum.SimpleSumRequest, com.example.grpc.Sum.SimpleSumResponse> getStreamSimpleSumMethod;
    if ((getStreamSimpleSumMethod = SimpleSumGrpc.getStreamSimpleSumMethod) == null) {
      synchronized (SimpleSumGrpc.class) {
        if ((getStreamSimpleSumMethod = SimpleSumGrpc.getStreamSimpleSumMethod) == null) {
          SimpleSumGrpc.getStreamSimpleSumMethod = getStreamSimpleSumMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Sum.SimpleSumRequest, com.example.grpc.Sum.SimpleSumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamSimpleSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Sum.SimpleSumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Sum.SimpleSumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SimpleSumMethodDescriptorSupplier("streamSimpleSum"))
              .build();
        }
      }
    }
    return getStreamSimpleSumMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SimpleSumStub newStub(io.grpc.Channel channel) {
    return new SimpleSumStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SimpleSumBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SimpleSumBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SimpleSumFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SimpleSumFutureStub(channel);
  }

  /**
   */
  public static abstract class SimpleSumImplBase implements io.grpc.BindableService {

    /**
     */
    public void streamSimpleSum(com.example.grpc.Sum.SimpleSumRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.Sum.SimpleSumResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamSimpleSumMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamSimpleSumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Sum.SimpleSumRequest,
                com.example.grpc.Sum.SimpleSumResponse>(
                  this, METHODID_STREAM_SIMPLE_SUM)))
          .build();
    }
  }

  /**
   */
  public static final class SimpleSumStub extends io.grpc.stub.AbstractStub<SimpleSumStub> {
    private SimpleSumStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleSumStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleSumStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleSumStub(channel, callOptions);
    }

    /**
     */
    public void streamSimpleSum(com.example.grpc.Sum.SimpleSumRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.Sum.SimpleSumResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStreamSimpleSumMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SimpleSumBlockingStub extends io.grpc.stub.AbstractStub<SimpleSumBlockingStub> {
    private SimpleSumBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleSumBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleSumBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleSumBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.Sum.SimpleSumResponse streamSimpleSum(com.example.grpc.Sum.SimpleSumRequest request) {
      return blockingUnaryCall(
          getChannel(), getStreamSimpleSumMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SimpleSumFutureStub extends io.grpc.stub.AbstractStub<SimpleSumFutureStub> {
    private SimpleSumFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleSumFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleSumFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleSumFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Sum.SimpleSumResponse> streamSimpleSum(
        com.example.grpc.Sum.SimpleSumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStreamSimpleSumMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_SIMPLE_SUM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SimpleSumImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SimpleSumImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_SIMPLE_SUM:
          serviceImpl.streamSimpleSum((com.example.grpc.Sum.SimpleSumRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Sum.SimpleSumResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SimpleSumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SimpleSumBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.Sum.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SimpleSum");
    }
  }

  private static final class SimpleSumFileDescriptorSupplier
      extends SimpleSumBaseDescriptorSupplier {
    SimpleSumFileDescriptorSupplier() {}
  }

  private static final class SimpleSumMethodDescriptorSupplier
      extends SimpleSumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SimpleSumMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SimpleSumGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SimpleSumFileDescriptorSupplier())
              .addMethod(getStreamSimpleSumMethod())
              .build();
        }
      }
    }
    return result;
  }
}
