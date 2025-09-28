package com.x.programming.grpc.client;

import com.x.programming.grpc.YoloGreeterGrpc;
import com.x.programming.grpc.YoloReply;
import com.x.programming.grpc.YoloRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class YoloClient {

    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "World";
        int port = 9090;
        String host = "localhost";

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        try {
            YoloGreeterGrpc.YoloGreeterBlockingStub stub = YoloGreeterGrpc.newBlockingStub(channel);
            YoloReply reply = stub.sayYolo(YoloRequest.newBuilder().setName(name).build());
            System.out.println(reply.getMessage());
        } finally {
            channel.shutdownNow();
        }
    }
}
