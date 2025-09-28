package com.x.grpc.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.x.grpc.GrpcSpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;

public class GreeterIntegrationTest {

    private static ConfigurableApplicationContext context;
    private static int port;

    private static int findFreePort() {
        try (ServerSocket socket = new ServerSocket(0)) {
            socket.setReuseAddress(true);
            return socket.getLocalPort();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll
    static void startServer() {
        port = findFreePort();
        context = SpringApplication.run(GrpcSpringBootApplication.class,
                "--grpc.server.port=" + port,
                "--spring.main.web-application-type=none");
    }

    @AfterAll
    static void stopServer() {
        if (context != null) {
            context.close();
        }
    }

    @Test
    void sayHello_returnsGreeting() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        try {
            GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
            HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName("Test").build());
            Assertions.assertEquals("Hello, Test", reply.getMessage());
        } finally {
            channel.shutdownNow();
        }
    }
}
