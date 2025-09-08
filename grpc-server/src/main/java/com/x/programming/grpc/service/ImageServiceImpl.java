package com.x.programming.grpc.service;

import com.google.protobuf.Empty;
import com.x.programming.grpc.*;
import com.x.programming.image.generator.ImageGenerator;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class ImageServiceImpl extends GetImageGrpc.GetImageImplBase {

    private final ImageGenerator imageGenerator;

    @Override
    public void getImage(Empty request, StreamObserver<ImageResponse> responseObserver) {
        // Implement image fetching logic here
        byte[] imageBytes = imageGenerator.fetchImage();

        ImageResponse response = ImageResponse.newBuilder()
                .setImageData(com.google.protobuf.ByteString.copyFrom(imageBytes))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
