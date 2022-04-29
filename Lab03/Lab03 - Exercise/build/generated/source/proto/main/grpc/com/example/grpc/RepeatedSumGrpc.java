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
public final class RepeatedSumGrpc {

  private RepeatedSumGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.RepeatedSum";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Sum.RepeatedSumRequest,
      com.example.grpc.Sum.RepeatedSumResponse> getStreamRepeatedSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamRepeatedSum",
      requestType = com.example.grpc.Sum.RepeatedSumRequest.class,
      responseType = com.example.grpc.Sum.RepeatedSumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.Sum.RepeatedSumRequest,
      com.example.grpc.Sum.RepeatedSumResponse> getStreamRepeatedSumMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Sum.RepeatedSumRequest, com.example.grpc.Sum.RepeatedSumResponse> getStreamRepeatedSumMethod;
    if ((getStreamRepeatedSumMethod = RepeatedSumGrpc.getStreamRepeatedSumMethod) == null) {
      synchronized (RepeatedSumGrpc.class) {
        if ((getStreamRepeatedSumMethod = RepeatedSumGrpc.getStreamRepeatedSumMethod) == null) {
          RepeatedSumGrpc.getStreamRepeatedSumMethod = getStreamRepeatedSumMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Sum.RepeatedSumRequest, com.example.grpc.Sum.RepeatedSumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamRepeatedSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Sum.RepeatedSumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Sum.RepeatedSumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RepeatedSumMethodDescriptorSupplier("streamRepeatedSum"))
              .build();
        }
      }
    }
    return getStreamRepeatedSumMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RepeatedSumStub newStub(io.grpc.Channel channel) {
    return new RepeatedSumStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RepeatedSumBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RepeatedSumBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RepeatedSumFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RepeatedSumFutureStub(channel);
  }

  /**
   */
  public static abstract class RepeatedSumImplBase implements io.grpc.BindableService {

    /**
     */
    public void streamRepeatedSum(com.example.grpc.Sum.RepeatedSumRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.Sum.RepeatedSumResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamRepeatedSumMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamRepeatedSumMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.grpc.Sum.RepeatedSumRequest,
                com.example.grpc.Sum.RepeatedSumResponse>(
                  this, METHODID_STREAM_REPEATED_SUM)))
          .build();
    }
  }

  /**
   */
  public static final class RepeatedSumStub extends io.grpc.stub.AbstractStub<RepeatedSumStub> {
    private RepeatedSumStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RepeatedSumStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RepeatedSumStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RepeatedSumStub(channel, callOptions);
    }

    /**
     */
    public void streamRepeatedSum(com.example.grpc.Sum.RepeatedSumRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.Sum.RepeatedSumResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamRepeatedSumMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RepeatedSumBlockingStub extends io.grpc.stub.AbstractStub<RepeatedSumBlockingStub> {
    private RepeatedSumBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RepeatedSumBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RepeatedSumBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RepeatedSumBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.grpc.Sum.RepeatedSumResponse> streamRepeatedSum(
        com.example.grpc.Sum.RepeatedSumRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamRepeatedSumMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RepeatedSumFutureStub extends io.grpc.stub.AbstractStub<RepeatedSumFutureStub> {
    private RepeatedSumFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RepeatedSumFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RepeatedSumFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RepeatedSumFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_REPEATED_SUM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RepeatedSumImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RepeatedSumImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_REPEATED_SUM:
          serviceImpl.streamRepeatedSum((com.example.grpc.Sum.RepeatedSumRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Sum.RepeatedSumResponse>) responseObserver);
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

  private static abstract class RepeatedSumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RepeatedSumBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.Sum.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RepeatedSum");
    }
  }

  private static final class RepeatedSumFileDescriptorSupplier
      extends RepeatedSumBaseDescriptorSupplier {
    RepeatedSumFileDescriptorSupplier() {}
  }

  private static final class RepeatedSumMethodDescriptorSupplier
      extends RepeatedSumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RepeatedSumMethodDescriptorSupplier(String methodName) {
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
      synchronized (RepeatedSumGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RepeatedSumFileDescriptorSupplier())
              .addMethod(getStreamRepeatedSumMethod())
              .build();
        }
      }
    }
    return result;
  }
}
