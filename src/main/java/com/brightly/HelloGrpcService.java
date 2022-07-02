package com.brightly;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class HelloGrpcService extends HelloGrpcGrpc.HelloGrpcImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String title = request.getTitle();
        String name = request.getName();

        String message = "Hello " + title + ", " + name + "! Welcome to Grpc World!!";

        responseObserver.onNext(HelloReply.newBuilder().setMessage(message).build());
        responseObserver.onCompleted();
    }
}
