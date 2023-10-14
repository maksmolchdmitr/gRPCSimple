package maks.molch.dmitr.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerApplication {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(SERVER_PORT)
                .addService(new GreetingServiceImpl())
                .build();
        server.start();
        System.out.println("Server was starting");
        server.awaitTermination();
    }
}
