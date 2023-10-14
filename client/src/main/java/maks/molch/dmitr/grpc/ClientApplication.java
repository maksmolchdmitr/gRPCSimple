package maks.molch.dmitr.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static maks.molch.dmitr.grpc.GreetingServiceGrpc.*;
import static maks.molch.dmitr.grpc.GreetingServiceOuterClass.*;

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
        HelloResponse response = stub.greeting(helloRequest);
        System.out.println(response);
        channel.shutdownNow();
    }
}
