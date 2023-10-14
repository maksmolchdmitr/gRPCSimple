package maks.molch.dmitr.grpc;

import io.grpc.stub.StreamObserver;

import static maks.molch.dmitr.grpc.GreetingServiceOuterClass.HelloRequest;
import static maks.molch.dmitr.grpc.GreetingServiceOuterClass.HelloResponse;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(String.format("Hello, %s!!!", request.getName()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
