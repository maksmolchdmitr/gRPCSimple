package maks.molch.dmitr.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

import static maks.molch.dmitr.grpc.GreetingServiceGrpc.GreetingServiceBlockingStub;
import static maks.molch.dmitr.grpc.GreetingServiceGrpc.newBlockingStub;
import static maks.molch.dmitr.grpc.GreetingServiceOuterClass.HelloRequest;
import static maks.molch.dmitr.grpc.GreetingServiceOuterClass.HelloResponse;

public class ClientApplication {
    private static final String host = "localhost";
    private static final int port = 8080;

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        GreetingServiceBlockingStub stub = newBlockingStub(channel);
        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setName("Maks :)")
                .build();
        Iterator<HelloResponse> responseIterator = stub.greeting(helloRequest);
        while (responseIterator.hasNext()) {
            var response = responseIterator.next();
            System.out.println(response);
        }
        channel.shutdownNow();
    }
}
